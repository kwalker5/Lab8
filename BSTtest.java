/*
 * Main testing class for BST
 * @author: USFCACS 245
 */
public class BSTtest
{
    public static void main(String[] args)
    {

        BST<String> tree = new BST<String>();


        int L = Integer.parseInt(args[0]);
        int R = Integer.parseInt(args[1]);
        for(int i=2; i < args.length; i++)
        {
            tree.insert(args[i]);

        }
        System.out.println("Original Tree:");
        tree.print();

        tree.delete(args[3]);
        System.out.println("Tree after deleting " + args[3]);
        tree.print();

        System.out.println("Finding " + args[4] + ": ");
        System.out.println(tree.find(args[4]));


        System.out.println("Range sum:" + tree.rangeSum(L, R));
    }
}