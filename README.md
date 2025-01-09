# Binary Tree Heap Validator

The **Binary Tree Heap Validator** is a system for validating operations on binary tree heaps, ensuring the integrity of heap invariants during addition and removal operations. This project supports modular validation through the Strategy Pattern and recursive algorithms, enabling flexibility and extensibility for different heap implementations.

---

## Features

### 1. Heap Validation
- Ensures correctness of **add** (`addInt(i)`) and **remove** (`removeInt(i)`) operations on binary tree heaps.
- Validation criteria include:
  - **Add Operation**:
    - The integer `i` must not exist in the current tree.
    - The resulting tree must include `i` and maintain the heap invariant.
  - **Remove Operation**:
    - The integer `i` must exist in the current tree.
    - The resulting tree must exclude `i` and maintain the heap invariant.

### 2. Max Heap Validation
- Implements recursive methods to validate:
  - The root node must be greater than all values in its subtrees.
  - All subtrees must also adhere to max heap properties.
- Supports efficient, recursive traversal without flattening trees into lists.

### 3. Extensibility with Strategy Pattern
- Includes modular strategies for heap operations:
  - Valid max heap strategies: `MaxHeapStrategy1`, `MaxHeapStrategy2`, `MaxHeapStrategy3`.
  - Faulty strategies (`FaultyMaxHeapStrategy1`, `FaultyMaxHeapStrategy2`) for testing.
- Easily extendable to min heaps or other custom heap strategies.

### 4. Binary Tree Representation
- **Immutable Binary Tree Interface (`IBinTree`)**:
  - Provides a structure for binary trees.
- **Tree Implementations**:
  - `EmptyBT`: Represents an empty leaf node.
  - `NodeBT`: Represents a tree node with an integer value and two subtrees.
- **BinaryTree Class**:
  - Encapsulates an `IBinTree` and provides mutable operations like `addInt()` and `removeInt()`.

---

## Recursive Validation

### Add Operation (`addInt(i)`)
1. Verifies that `i` does not exist in the current tree.
2. Ensures `i` is added while maintaining the max heap invariant:
   - The root node is greater than or equal to all values in its subtrees.
   - Subtrees are also valid max heaps.

### Remove Operation (`removeInt(i)`)
1. Ensures `i` exists in the current tree.
2. Removes `i` and ensures the resulting tree maintains:
   - Max heap properties.
   - Only the remaining elements of the original tree.

---
