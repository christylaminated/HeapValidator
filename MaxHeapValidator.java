public class MaxHeapValidator implements BTValidator {
    /**
     * Check if adding newItem to the oldStructure and getting the updatedStructure is possible with the current invariants.
     *
     * @param oldStructure      the given tree we assume respects the invariants
     * @param newItem           the element to add
     * @param updatedStructure  the updated tree which we are validating
     * @return true if we determine that the updated tree respects the invariants
     */
    @Override
    public boolean validAdd(IBinTree oldStructure, int newItem, IBinTree updatedStructure) {
        return this.contains(updatedStructure, newItem) && this.allIn(oldStructure, updatedStructure) && updatedStructure.size() == oldStructure.size() + 1 &&
                this.isMaxHeap(updatedStructure);
    }

    /**
     * Check if removing removedItem from the oldStructure and getting the updatedStructure is possible with the current invariants.
     *
     * @param oldStructure      the given tree we assume respects the invariants
     * @param removedItem       the element to remove
     * @param updatedStructure  the updated tree which we are validating
     * @return true if we determine that the updated tree respects the invariants
     */
    @Override
    public boolean validRemove(IBinTree oldStructure, int removedItem, IBinTree updatedStructure) {
        return (!this.contains(updatedStructure, removedItem)) && this.allIn(updatedStructure, oldStructure) && updatedStructure.size() == oldStructure.size() - 1 &&
                this.isMaxHeap(updatedStructure);
    }

    // Helper functions

    /**
     * Check if the given binary tree satisfies the Max Heap property.
     *
     * @param aStructure the binary tree to check
     * @return true if the tree is a Max Heap, false otherwise
     */
    private boolean isMaxHeap(IBinTree aStructure) {
        if (aStructure.isEmpty()) {
            return true;
        } else {
            boolean leftSideGood = this.biggerThanAll(aStructure.getRoot(), aStructure.getLeft());
            boolean rightSideGood = this.biggerThanAll(aStructure.getRoot(), aStructure.getRight());

            return leftSideGood && rightSideGood && this.isMaxHeap(aStructure.getLeft()) && this.isMaxHeap(aStructure.getRight());
        }
    }

    /**
     * Check if the given element is greater than all elements in the binary tree.
     *
     * @param element    the element to compare
     * @param aStructure the binary tree to compare against
     * @return true if the element is greater than all elements in the tree, false otherwise
     */
    private boolean biggerThanAll(int element, IBinTree aStructure) {
        if (aStructure.isEmpty()) {
            return true;
        } else {
            return element > aStructure.getRoot() &&
                    this.biggerThanAll(element, aStructure.getLeft()) && this.biggerThanAll(element, aStructure.getRight());
        }
    }

    /**
     * Check if the given binary tree contains a specific item.
     *
     * @param aStructure the binary tree to search
     * @param item       the item to search for
     * @return true if the item is found in the tree, false otherwise
     */
    private boolean contains(IBinTree aStructure, int item) {
        if (aStructure.isEmpty()) {
            return false;
        } else {
            return aStructure.getRoot() == item || this.contains(aStructure.getLeft(), item) || this.contains(aStructure.getRight(), item);
        }
    }

    /**
     * Check if all elements in one binary tree are present in another binary tree.
     *
     * @param elements  the binary tree containing elements to check
     * @param container the binary tree to check against
     * @return true if all elements in the first tree are present in the second tree, false otherwise
     */
    private boolean allIn(IBinTree elements, IBinTree container) {
        if (elements.isEmpty()) {
            return true;
        } else {
            return this.contains(container, elements.getRoot()) &&
                    this.allIn(elements.getLeft(), container) &&
                    this.allIn(elements.getRight(), container);
        }
    }
}

