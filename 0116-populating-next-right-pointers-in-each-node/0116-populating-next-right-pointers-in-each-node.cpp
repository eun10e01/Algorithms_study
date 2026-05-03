#include <vector>
#include <string>
#include <queue>

using namespace std;

/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;
    Node() : val(0), left(NULL), right(NULL), next(NULL) {}
    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}
    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        if (!root) {
            return nullptr;
        }

        queue<Node*> q;
        q.push(root);

        while (!q.empty()) {
            int size = q.size();
            Node* prev = nullptr;

            for (int i = 0; i < size; ++i) {
                Node* current = q.front();
                q.pop();

                //이전 노드의 next를 현재 노드로 설정
                if (prev) {
                    prev->next = current;
                }
                prev = current;

                //자식 노드 큐에 추가
                if (current->left) q.push(current->left);
                if (current->right) q.push(current->right);
            }
        }

        return root;
    }
};