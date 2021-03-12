package com.example.tree;

/**
 * https://www.geeksforgeeks.org/minimum-time-to-burn-a-tree-starting-from-a-leaf-node/
 * Minimum time to burn a Tree starting from a Leaf node
 * Difficulty Level : Hard
 *  Last Updated : 14 Feb, 2020
 * Given a binary tree and a leaf node from this tree. It is known that in 1s all nodes connected to a given node (left child, right child and parent) get burned in 1 second. Then all the nodes which are connected through one intermediate get burned in 2 seconds, and so on. The task is to find the minimum time required to burn the complete binary tree.
 *
 *
 * Examples:
 *
 * Input :
 *             1
 *        /       \
 *       2          3
 *     /  \          \
 *    4    5          6
 *       /   \         \
 *      7     8         9
 *                       \
 *                        10
 * Leaf = 8
 * Output : 7
 * Initially 8 is set to fire at 0th sec.
 *             1
 *        /       \
 *       2          3
 *     /  \          \
 *    4    5          6
 *       /   \         \
 *      7     F         9
 *                       \
 *                        10
 * After 1s: 5 is set to fire.
 *             1
 *        /       \
 *       2          3
 *     /  \          \
 *    4    F          6
 *       /   \         \
 *      7     F         9
 *                       \
 *                        10
 * After 2s: 2, 7 are set to fire.
 *             1
 *        /       \
 *       F          3
 *     /  \          \
 *    4    F          6
 *       /   \         \
 *      F     F         9
 *                       \
 *                        10
 * After 3s: 4, 1 are set to fire.
 *             F
 *        /       \
 *       F          3
 *     /  \          \
 *    F    F          6
 *       /   \         \
 *      F     F         9
 *                       \
 *                        10
 * After 4s: 3 is set to fire.
 *             F
 *        /       \
 *       F          F
 *     /  \          \
 *    F    F          6
 *       /   \         \
 *      F     F         9
 *                       \
 *                        10
 * After 5s: 6 is set to fire.
 *             F
 *        /       \
 *       F          F
 *     /  \          \
 *    F    F          F
 *       /   \         \
 *      F     F         9
 *                       \
 *                        10
 * After 6s: 9 is set to fire.
 *             F
 *        /       \
 *       F          F
 *     /  \          \
 *    F    F          F
 *       /   \         \
 *      F     F         F
 *                       \
 *                        10
 * After 7s: 10 is set to fire.
 *             F
 *        /       \
 *       F          F
 *     /  \          \
 *    F    F          F
 *       /   \         \
 *      F     F         F
 *                       \
 *                        F
 * It takes 7s to burn the complete tree.
 */
public class MinimumTimeToBurnTree {
}
