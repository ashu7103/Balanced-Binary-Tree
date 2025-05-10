## Whats is this project
1. This project demonstrates how to create an ** Binary Search Tree (BST)** 
2. How to convert it into a **balanced BST** by performing operations directly on the tree structure — without converting it into an array.

## 🧠 Concept Overview

### 1. Create a Binary Search Tree (BST)
- A **BST** is built by inserting nodes such that:
  - Left child < Parent < Right child.
- The tree may become **unbalanced** if elements are inserted in sorted or skewed order.

### 2. Balance the BST (Without Using Array)
- Instead of converting the tree into a sorted array (like in some approaches), this project balances the BST **in-place** using **tree rotation and height checks**.
- This approach is conceptually similar to how **AVL Trees** maintain balance.

### 🔁 Balancing Logic:
- After each insertion, check the **balance factor** (difference between heights of left and right subtrees).
- If the balance factor is not in `[-1, 0, 1]`, perform **rotations** to restore balance:
  - **Left Rotation**
  - **Right Rotation**
  - **Left-Right Rotation**
  - **Right-Left Rotation**
  -  https://www.geeksforgeeks.org/introduction-to-avl-tree/  ( for concept)

> This ensures that the tree remains height-balanced after each insertion, improving efficiency of operations like search, insert, and delete.

## 🧪 Example

Given insertion order: `30, 20, 10`

- Initially:

```
    30
   /
  20
 /
10

```

- After balancing:

```
  20
 /  \
10  30

````

## 📁 Files

- `BST`: Contains the BST creation 
- `Balance BST` : Make BST int0 balanced BST
- `BST Node` : Node of Tree
- `README.md`: Project explanation.

## 📘 Method Summary – `BST.java`

| Method Name                              | What It Does                                                    | How / Where It’s Used                                                    |
| ---------------------------------------- | --------------------------------------------------------------- | ------------------------------------------------------------------------ |
| `BST()`                                  | Constructor – Initializes an empty BST.                         | Automatically called when `BST a = new BST();`                           |
| `void insert(int num)`                   | Inserts a new node with value `num` into BST.                   | Called in `main()` or by user to grow the tree.                          |
| `boolean delete(int num)`                | Deletes a node with value `num` if it exists.                   | Calls helper `h_delete()`; returns success status.                       |
| `boolean search(int num)`                | Searches if a value exists in the BST.                          | Calls helper `search_button()`; logs search result.                      |
| `ArrayList<Integer> inorder()`           | Returns BST values in **ascending order**.                      | Uses helper `h_inorder()` for recursion.                                 |
| `ArrayList<Integer> preorder()`          | Returns BST values in **root-left-right** order.                | Uses helper `h_preorder()`.                                              |
| `ArrayList<Integer> postorder()`         | Returns BST values in **left-right-root** order.                | Uses helper `h_postorder()`.                                             |
| `void updateHeight(BSTNode)`             | Updates the `height` of each node recursively.                  | Maintains AVL-style height metadata; not actively used in insert/delete. |
| `BSTNode search_node(int, root)`         | Finds and returns node with a specific value.                   | Used in tests or internal logic like `left_max`.                         |
| `BSTNode h_delete(root, num)`            | Recursive delete helper that returns the modified subtree root. | Called inside `delete()` only if value exists.                           |
| `boolean search_button(num, node)`       | Recursive boolean search helper.                                | Used by `search()`.                                                      |
| `int left_max(root)`                     | Finds the maximum value in left subtree.                        | Used in deletion (when replacing node with in-order predecessor).        |
| `int right_min(root)`                    | Finds minimum value in right subtree.                           | Present but not used in this code.                                       |

## 📘 Method Summary – `BalancedBST.java`

| Method Name                             | What It Does                                                     | How / Where It’s Used                                       |
| --------------------------------------- | ---------------------------------------------------------------- | ----------------------------------------------------------- |
| `int height(BSTNode)`                   | Returns height of a node, returns 0 if null.                     | Used in rotation methods and height updates.                |
| `int checkbalance(BSTNode)`             | Returns the balance factor of a node.                            | Used in balancing decisions after insertions and deletions. |
| `BSTNode Left_rotation(Node)`           | Performs a **left rotation** to balance tree.                    | Used in `tobalance()` for imbalance correction.             |
| `BSTNode right_rotation(Node)`          | Performs a **right rotation** to balance tree.                   | Used in `tobalance()` for imbalance correction.             |
| `BSTNode helper_insert(node, key)`      | Recursively inserts a value while updating height and balancing. | Called by `insert(int key)`                                 |
| `BSTNode tobalance(node, balance, key)` | Chooses the right rotation type based on balance factor and key. | Called from `helper_insert()` and `helperDelete()`          |
| `BSTNode helperDelete(node, key)`       | Recursively deletes a node and re-balances the tree.             | Called by `delete(int key)`                                 |
| `void insert(int key)`                  | Public insert wrapper that starts AVL insert process.            | Used by the user or `main()`                                |
| `boolean delete(int key)`               | Public delete wrapper that starts AVL delete process.            | Returns success/failure of deletion                         |




## 📌 Note

* This is a **manual balancing** implementation using rotations (not using AVL/Red-Black library).
* Focuses on understanding how balancing works structurally on a tree.

## 👨‍💻 Author

Ashutosh ([@ashu7103](https://github.com/ashu7103))

