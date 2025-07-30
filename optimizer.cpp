#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <unordered_set>
#include <regex>

bool isRedundantMov(const std::string& line1, const std::string& line2) {
    std::smatch m1, m2;
    std::regex movRegex(R"(MOV\s+(\w+),\s*(\w+))", std::regex::icase);
    if (std::regex_search(line1, m1, movRegex) && std::regex_search(line2, m2, movRegex)) {
        return (m1[1] == m2[2] && m1[2] == m2[1]);
    }
    return false;
}

bool isRedundantPushPop(const std::string& line1, const std::string& line2) {
    std::smatch m1, m2;
    std::regex pushRegex(R"(PUSH\s+(\w+))", std::regex::icase);
    std::regex popRegex(R"(POP\s+(\w+))", std::regex::icase);
    if (std::regex_search(line1, m1, pushRegex) && std::regex_search(line2, m2, popRegex)) {
        return (m1[1] == m2[1]);
    }
    return false;
}

bool isRedundantArithmetic(const std::string& line) {
    std::smatch m;
    std::regex add0(R"((ADD|SUB)\s+\w+,\s*0)", std::regex::icase);
    std::regex mul1(R"((MUL|IMUL)\s+\w+,\s*1)", std::regex::icase);
    return std::regex_search(line, m, add0) || std::regex_search(line, m, mul1);
}

bool isLabel(const std::string& line) {
    return std::regex_match(line, std::regex(R"(\s*(\w+):)"));
}

std::string getLabelName(const std::string& line) {
    std::smatch m;
    if (std::regex_match(line, m, std::regex(R"(\s*(\w+):)")))
        return m[1];
    return "";
}

std::unordered_set<std::string> findJumpTargets(const std::vector<std::string>& lines) {
    std::unordered_set<std::string> targets;
    std::regex jumpRegex(R"(\b(JMP|JE|JNE|JG|JL|JGE|JLE|CALL)\s+(\w+))", std::regex::icase);
    std::smatch match;

    for (const auto& line : lines) {
        if (std::regex_search(line, match, jumpRegex)) {
            targets.insert(match[2]);
        }
    }

    return targets;
}

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: " << argv[0] << " input.asm\n";
        return 1;
    }

    std::ifstream infile(argv[1]);
    std::ofstream outfile("optimized.asm");

    if (!infile) {
        std::cerr << "Error: Cannot open " << argv[1] << "\n";
        return 1;
    }

    std::vector<std::string> lines, result;
    std::string line;
    while (std::getline(infile, line)) {
        lines.push_back(line);
    }

    auto jumpTargets = findJumpTargets(lines);

    for (size_t i = 0; i < lines.size(); ++i) {
        std::string trimmed = std::regex_replace(lines[i], std::regex(R"(^\s+|\s+$)"), "");
        if (trimmed.empty()) {
            result.push_back(lines[i]);
            continue;
        }

        // Redundant MOV
        if (i + 1 < lines.size() && isRedundantMov(lines[i], lines[i + 1])) {
            result.push_back(lines[i]);
            ++i;
            continue;
        }

        // Redundant PUSH-POP
        if (i + 1 < lines.size() && isRedundantPushPop(lines[i], lines[i + 1])) {
            ++i;
            continue;
        }

        // Redundant Arithmetic
        if (isRedundantArithmetic(lines[i])) {
            continue;
        }

        // Redundant labels (only if not jump targets)
        if (isLabel(lines[i])) {
            std::string currLabel = getLabelName(lines[i]);
            result.push_back(lines[i]);

            while (i + 1 < lines.size() && isLabel(lines[i + 1])) {
                std::string nextLabel = getLabelName(lines[i + 1]);
                if (jumpTargets.find(nextLabel) != jumpTargets.end()) {
                    result.push_back(lines[i + 1]);  // can't remove if it's a target
                }
                ++i;
            }
            continue;
        }

        result.push_back(lines[i]);
    }

    for (const auto& l : result) {
        outfile << l << '\n';
    }

    std::cout << "Optimized code written to optimized.asm\n";
    return 0;
}
