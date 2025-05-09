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



## 📌 Note

* This is a **manual balancing** implementation using rotations (not using AVL/Red-Black library).
* Focuses on understanding how balancing works structurally on a tree.

## 👨‍💻 Author

Ashutosh ([@ashu7103](https://github.com/ashu7103))

