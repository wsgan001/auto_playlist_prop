package prop.domain;

import java.util.ArrayList;

/**
 * @author joaquim.motger
 */

/**
 * Implementation of ternary search tree. A Ternary Search Tree is a data structure that behaves
 * in a manner that is very similar to a HashMap.
 */
public class TernarySearchTree<E> {
    private final static String escape_char = "\n";
    private static final char token = 254;
    private TSTNode<E> rootNode;
    private int defaultNumReturnValues;
    private int size;

    public TernarySearchTree() {
        defaultNumReturnValues = -1;
        size = -1;
        put(String.valueOf(token),null);
    }

    private static int compareCharsAlphabetically(char cCompare, char cRef) {
        return (alphabetizeChar(cCompare) - alphabetizeChar(cRef));
    }

    private static int alphabetizeChar(char c) {
        if (c < 65) return c;
        if (c < 89) return (2 * c) - 65;
        if (c < 97) return c + 24;
        if (c < 121) return (2 * c) - 128;

        return c;
    }

    public int getSize() {
        return size;
    }

    /**
     * Stores value in the TernarySearchTree. The value may be retrieved using key.
     *
     * @param key   A string that indexes the object to be stored.
     * @param value The object to be stored in the tree.
     */
    public void put(String key, E value) {
        ++size;
        getOrCreateNode(key + escape_char).data = value;
    }

    /**
     * Retrieve the object indexed by key.
     *
     * @param key A String index.
     * @return Object The object retrieved from the TernarySearchTree.
     */
    public E get(String key) {
        TSTNode<E> node = getNode(key + escape_char);
        if (node == null) return null;
        return node.data;
    }

    public boolean contains(String key) {
        TSTNode<E> node = getNode(key + escape_char);
        if (node == null) return false;
        else return true;
    }

    /**
     * Removes value indexed by key. Also removes all nodes that are rendered unnecessary by the removal of this data.
     *
     * @param key A string that indexes the object to be removed from the tree.
     */
    public E remove(String key) {
        key += escape_char;
        --size;
        TSTNode<E> node = getNode(key);
        deleteNode(getNode(key));
        return (node != null ? node.data : null);
    }

    /**
     * Sets default maximum number of values returned from matchPrefix, matchPrefixString,
     * matchAlmost, and matchAlmostString methods.
     *
     * @param num The number of values that will be returned when calling the methods above. Set
     *            this to -1 to get an unlimited number of return values. Note that
     *            the methods mentioned above provide overloaded versions that allow you to specify the maximum number of
     *            return values, in which case this value is temporarily overridden.
     */
    public void setNumReturnValues(int num) {
        defaultNumReturnValues = (num < 0) ? -1 : num;
    }

    private int checkNumberOfReturnValues(int numReturnValues) {
        return ((numReturnValues < 0) ? -1 : numReturnValues);
    }

    /**
     * Returns the Node indexed by key, or null if that node doesn't exist. Search begins at root node.
     *
     * @param key An index that points to the desired node.
     * @return TSTNode The node object indexed by key. This object is an instance of an inner class
     * named TernarySearchTree.TSTNode.
     */
    public TSTNode<E> getNode(String key) {
        return getNode(key, rootNode);
    }

    /**
     * Returns the Node indexed by key, or null if that node doesn't exist. Search begins at root node.
     *
     * @param key       An index that points to the desired node.
     * @param startNode The top node defining the subtree to be searched.
     * @return TSTNode The node object indexed by key. This object is an instance of an inner class
     * named TernarySearchTree.TSTNode.
     */
    protected TSTNode<E> getNode(String key, TSTNode<E> startNode) {
        if (key == null || startNode == null || key.length() == 0) return null;
        TSTNode<E> currentNode = startNode;
        int charIndex = 0;

        while (true) {
            if (currentNode == null) return null;
            int charComp = compareCharsAlphabetically(key.charAt(charIndex), currentNode.splitchar);

            if (charComp == 0) {
                charIndex++;
                if (charIndex == key.length()) return currentNode;
                currentNode = currentNode.relatives[TSTNode.EQKID];
            } else if (charComp < 0) {
                currentNode = currentNode.relatives[TSTNode.LOKID];
            } else {
                // charComp must be greater than zero
                currentNode = (TSTNode<E>) currentNode.relatives[TSTNode.HIKID];
            }
        }
    }

    public ArrayList<E> matchPrefix(char prefix) {
        String p = String.valueOf(prefix);
        return matchPrefix(p, defaultNumReturnValues);
    }

    public ArrayList<E> matchPrefix(String prefix) {
        return matchPrefix(prefix, defaultNumReturnValues);
    }

    public ArrayList<E> getList() {
        ArrayList<E> list = new ArrayList<>();
        char c = 33;
        for (int i = 0; i < 32; ++i) {
            list.addAll(matchPrefix(c));
            c += 1;
        }
        char d = 'a';
        c = 'A';
        for (int i = 0; i < 26; ++i) {
            list.addAll(matchPrefix(c));
            list.addAll(matchPrefix(d));
            c += 1;
            d += 1;
        }
        c = 91;
        for (int i = 0; i < 6; ++i) {
            list.addAll(matchPrefix(c));
            c += 1;
        }
        c = 123;
        for (int i = 0; i < 131; ++i) {
            list.addAll(matchPrefix(c));
            c += 1;
        }
        return list;
    }

    public ArrayList<E> matchPrefix(String prefix, int numReturnValues) {
        int sortKeysNumReturnValues = checkNumberOfReturnValues(numReturnValues);
        ArrayList<E> sortKeysResult = new ArrayList<E>();
        TSTNode<E> startNode = getNode(prefix);

        if (startNode == null) return sortKeysResult;
        if (startNode.data != null) {
            sortKeysResult.add(startNode.data);
            sortKeysNumReturnValues--;
        }

        sortKeysRecursion(sortKeysResult, startNode.relatives[TSTNode.EQKID], sortKeysNumReturnValues);

        return sortKeysResult;
    }

    private void sortKeysRecursion(ArrayList<E> sortKeysResult, TSTNode<E> currentNode, int sortKeysNumReturnValues) {
        if (currentNode == null) return;
        sortKeysRecursion(sortKeysResult, currentNode.relatives[TSTNode.LOKID], sortKeysNumReturnValues);
        if (sortKeysNumReturnValues == 0) return;

        if (currentNode.data != null) {
            sortKeysResult.add(currentNode.data);
            sortKeysNumReturnValues--;
        }

        sortKeysRecursion(sortKeysResult, currentNode.relatives[TSTNode.EQKID], sortKeysNumReturnValues);
        sortKeysRecursion(sortKeysResult, currentNode.relatives[TSTNode.HIKID], sortKeysNumReturnValues);
    }

    protected ArrayList<E> sortKeys(TSTNode<E> startNode, int numReturnValues) {
        int sortKeysNumReturnValues = checkNumberOfReturnValues(numReturnValues);
        ArrayList<E> sortKeysResult = new ArrayList<E>();
        sortKeysRecursion(sortKeysResult, startNode, sortKeysNumReturnValues);
        return sortKeysResult;
    }

    /**
     * Returns the Node indexed by key, creating that node if it doesn't exist, and creating any required.
     * intermediate nodes if they don't exist.
     *
     * @param key A string that indexes the node that is returned.
     * @return TSTNode The node object indexed by key. This object is an instance of an inner class
     * named TernarySearchTree.TSTNode.
     */
    protected TSTNode<E> getOrCreateNode(String key) throws NullPointerException, IllegalArgumentException {
        if (rootNode == null) rootNode = new TSTNode<E>(key.charAt(0), null);

        TSTNode<E> currentNode = rootNode;
        int charIndex = 0;
        while (true) {
            int charComp = compareCharsAlphabetically(key.charAt(charIndex), currentNode.splitchar);

            if (charComp == 0) {
                charIndex++;
                if (charIndex == key.length()) return currentNode;
                if (currentNode.relatives[TSTNode.EQKID] == null)
                    currentNode.relatives[TSTNode.EQKID] = new TSTNode<E>(key.charAt(charIndex), currentNode);
                currentNode = currentNode.relatives[TSTNode.EQKID];
            } else if (charComp < 0) {
                if (currentNode.relatives[TSTNode.LOKID] == null)
                    currentNode.relatives[TSTNode.LOKID] = new TSTNode<E>(key.charAt(charIndex), currentNode);
                currentNode = currentNode.relatives[TSTNode.LOKID];
            } else {
                // charComp must be greater than zero
                if (currentNode.relatives[TSTNode.HIKID] == null)
                    currentNode.relatives[TSTNode.HIKID] = new TSTNode<E>(key.charAt(charIndex), currentNode);
                currentNode = currentNode.relatives[TSTNode.HIKID];
            }
        }
    }

    /* Deletes the node passed in as an argument to this method. If this node has non-null data, then both the node and the data will be deleted.
     * Also deletes any other nodes in the tree that are no longer needed after the deletion of the node first passed in as an argument to this method.
     */
    private void deleteNode(TSTNode<E> nodeToDelete) {
        if (nodeToDelete == null) return;
        nodeToDelete.data = null;

        while (nodeToDelete != null) {
            nodeToDelete = deleteNodeRecursion(nodeToDelete);
        }
    }

    private TSTNode<E> deleteNodeRecursion(TSTNode<E> currentNode) {
        // To delete a node, first set its data to null, then pass it into this method, then pass the node returned by this method into this method
        // (make sure you don't delete the data of any of the nodes returned from this method!)
        // and continue in this fashion until the node returned by this method is null.
        // The TSTNode instance returned by this method will be next node to be operated on by deleteNodeRecursion.
        // (This emulates recursive method call while avoiding the JVM overhead normally associated with a recursive method.)

        if (currentNode == null) return null;
        if (currentNode.relatives[TSTNode.EQKID] != null || currentNode.data != null)
            return null;  // can't delete this node if it has a non-null eq kid or data

        TSTNode<E> currentParent = currentNode.relatives[TSTNode.PARENT];

        // if we've made it this far, then we know the currentNode isn't null, but its data and equal kid are null, so we can delete the current node
        // (before deleting the current node, we'll move any lower nodes higher in the tree)
        boolean lokidNull = currentNode.relatives[TSTNode.LOKID] == null;
        boolean hikidNull = currentNode.relatives[TSTNode.HIKID] == null;

        ////////////////////////////////////////////////////////////////////////
        // Add by Cheok. To resolve java.lang.NullPointerException
        // I am not sure this is the correct solution, as I have not gone
        // through this sourc code in detail.
        if (currentParent == null && currentNode == this.rootNode) {
            // if this executes, then current node is root node
            rootNode = null;
            return null;
        }
        // Add by Cheok. To resolve java.lang.NullPointerException
        ////////////////////////////////////////////////////////////////////////

        // now find out what kind of child current node is
        int childType;
        if (currentParent.relatives[TSTNode.LOKID] == currentNode) {
            childType = TSTNode.LOKID;
        } else if (currentParent.relatives[TSTNode.EQKID] == currentNode) {
            childType = TSTNode.EQKID;
        } else if (currentParent.relatives[TSTNode.HIKID] == currentNode) {
            childType = TSTNode.HIKID;
        } else {
            // if this executes, then current node is root node
            rootNode = null;
            return null;
        }

        if (lokidNull && hikidNull) {
            // if we make it to here, all three kids are null and we can just delete this node
            currentParent.relatives[childType] = null;
            return currentParent;
        }

        // if we make it this far, we know that EQKID is null, and either HIKID or LOKID is null, or both HIKID and LOKID are NON-null
        if (lokidNull) {
            currentParent.relatives[childType] = currentNode.relatives[TSTNode.HIKID];
            currentNode.relatives[TSTNode.HIKID].relatives[TSTNode.PARENT] = currentParent;
            return currentParent;
        }

        if (hikidNull) {
            currentParent.relatives[childType] = currentNode.relatives[TSTNode.LOKID];
            currentNode.relatives[TSTNode.LOKID].relatives[TSTNode.PARENT] = currentParent;
            return currentParent;
        }

        int deltaHi = currentNode.relatives[TSTNode.HIKID].splitchar - currentNode.splitchar;
        int deltaLo = currentNode.splitchar - currentNode.relatives[TSTNode.LOKID].splitchar;
        int movingKid;
        TSTNode<E> targetNode;

        // if deltaHi is equal to deltaLo, then choose one of them at random, and make it "further away" from the current node's splitchar
        if (deltaHi == deltaLo) {
            if (Math.random() < 0.5) {
                deltaHi++;
            } else {
                deltaLo++;
            }
        }

        if (deltaHi > deltaLo) {
            movingKid = TSTNode.HIKID;
            targetNode = currentNode.relatives[TSTNode.LOKID];
        } else {
            movingKid = TSTNode.LOKID;
            targetNode = currentNode.relatives[TSTNode.HIKID];
        }

        while (targetNode.relatives[movingKid] != null) targetNode = targetNode.relatives[movingKid];

        // now targetNode.relatives[movingKid] is null, and we can put the moving kid into it.
        targetNode.relatives[movingKid] = currentNode.relatives[movingKid];

        // now we need to put the target node where the current node used to be
        currentParent.relatives[childType] = targetNode;
        targetNode.relatives[TSTNode.PARENT] = currentParent;

        if (!lokidNull) currentNode.relatives[TSTNode.LOKID] = null;
        if (!hikidNull) currentNode.relatives[TSTNode.HIKID] = null;

        // note that the statements above ensure currentNode is completely dereferenced, and so it will be garbage collected
        return currentParent;
    }

    /**
     * An inner class of TernarySearchTree that represents a node in the tree.
     */
    private static final class TSTNode<E> {
        protected static final int PARENT = 0, LOKID = 1, EQKID = 2, HIKID = 3; // index values for accessing relatives array
        protected char splitchar;

        @SuppressWarnings("unchecked")
        protected TSTNode<E>[] relatives = new TSTNode[4];
        protected E data;

        protected TSTNode(char splitchar, TSTNode<E> parent) {
            this.splitchar = splitchar;
            relatives[PARENT] = parent;
        }
    }
}