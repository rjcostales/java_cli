/* prototype for recursive puzzle */

import java.util.Date;

enum COLOR {red, green, blue, purple}

enum PART {head, tail}

public class Puzzle {
    static COLOR red = COLOR.red;
    static COLOR green = COLOR.green;
    static COLOR blue = COLOR.blue;
    static COLOR purple = COLOR.purple;
    static PART head = PART.head;
    static PART tail = PART.tail;

    static Square[] box = {
            new Square(0, new Side(red, head), new Side(red, tail), new Side(green, head), new Side(blue, tail)),
            new Square(1, new Side(purple, tail), new Side(red, tail), new Side(blue, head), new Side(blue, tail)),
            new Square(2, new Side(purple, head), new Side(green, head), new Side(red, tail), new Side(blue, head)),
            new Square(3, new Side(purple, head), new Side(red, tail), new Side(green, tail), new Side(blue, tail)),
            new Square(4, new Side(purple, tail), new Side(green, head), new Side(blue, tail), new Side(red, tail)),
            new Square(5, new Side(purple, tail), new Side(green, tail), new Side(red, head), new Side(blue, head)),
            new Square(6, new Side(purple, tail), new Side(blue, head), new Side(red, tail), new Side(green, head)),
            new Square(7, new Side(purple, tail), new Side(red, head), new Side(green, head), new Side(blue, head)),
            new Square(8, new Side(purple, head), new Side(green, head), new Side(purple, head), new Side(green, tail))};

    static int count = 0;

    public static void main(String argv[]) {

        Date start = new Date();
        System.out.println("Started...");

        permute(box.length);

        Date stop = new Date();
        long delta = stop.getTime() - start.getTime();

        System.out.println("Searched " + count + " puzzles in " + delta / 1000.0 + " seconds");
    }

    public static void permute(int n) {
        if (n != 0) {
            for (int i = n - 1; i >= 0; i--) {
                swap(n - 1, i);
                permute(n - 1);
                swap(i, n - 1);
            }
        } else {
            count++;
            find();
            box[4].rotate();
            find();
            box[4].rotate();
            find();
            box[4].rotate();
            find();
        }
    }

    public static void find() {

        // sided
        for (int tries = 4; tries > 0; tries--)
            if (Side.matched(box[4].top, box[1].bottom))
                break;
            else
                box[1].rotate();
        if (Side.unmatched(box[4].top, box[1].bottom))
            return;

        for (int tries = 4; tries > 0; tries--)
            if (Side.matched(box[4].left, box[3].right))
                break;
            else
                box[3].rotate();
        if (Side.unmatched(box[4].left, box[3].right))
            return;

        for (int tries = 4; tries > 0; tries--)
            if (Side.matched(box[4].right, box[5].left))
                break;
            else
                box[5].rotate();
        if (Side.unmatched(box[4].right, box[5].left))
            return;

        for (int tries = 3; tries > 0; tries--)
            if (Side.matched(box[4].bottom, box[7].top))
                break;
            else
                box[7].rotate();
        if (Side.unmatched(box[4].bottom, box[7].top))
            return;

        // corners
        for (int tries = 4; tries > 0; tries--)
            if (Side.matched(box[0].right, box[1].left) && Side.matched(box[0].bottom, box[3].top))
                break;
            else
                box[0].rotate();
        if (Side.unmatched(box[0].right, box[1].left) || Side.unmatched(box[0].bottom, box[3].top))
            return;

        for (int tries = 4; tries > 0; tries--)
            if (Side.matched(box[2].left, box[1].right) && Side.matched(box[2].bottom, box[5].top))
                break;
            else
                box[2].rotate();
        if (Side.unmatched(box[2].left, box[1].right) || Side.unmatched(box[2].bottom, box[5].top))
            return;

        for (int tries = 4; tries > 0; tries--)
            if (Side.matched(box[6].top, box[3].bottom) && Side.matched(box[6].right, box[7].left))
                break;
            else
                box[6].rotate();
        if (Side.unmatched(box[6].top, box[3].bottom) || Side.unmatched(box[6].right, box[7].left))
            return;

        for (int tries = 4; tries > 0; tries--)
            if (Side.matched(box[8].top, box[5].bottom) && Side.matched(box[8].left, box[7].right))
                break;
            else
                box[8].rotate();
        if (Side.unmatched(box[8].top, box[5].bottom) || Side.unmatched(box[8].left, box[7].right))
            return;

        System.out.println();
        System.out.println("Solution in " + count + " moves");
        for (int i = 0; i < 9; i++)
            box[i].print();
    }

    public static void swap(int i, int j) {
        Square t = box[i];
        box[i] = box[j];
        box[j] = t;
    }
}

class Side {
    COLOR color;
    PART part;

    Side(COLOR color, PART part) {
        this.color = color;
        this.part = part;
    }

    static boolean unmatched(Side a, Side b) {
        return (a.color != b.color || a.part == b.part);
    }

    static boolean matched(Side a, Side b) {
        return (a.color == b.color && a.part != b.part);
    }

    void print() {
        System.out.print(color + ":" + part + ", ");
    }

    @Override
    public String toString() {
        return "Side [color=" + color + ", part=" + part + "]";
    }
}

class Square {
    int id;
    Side top;
    Side left;
    Side right;
    Side bottom;

    Square(int id, Side top, Side right, Side bottom, Side left) {
        this.id = id;
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
    }

    void rotate() {
        Side temp;
        temp = top;
        top = right;
        right = bottom;
        bottom = left;
        left = temp;
    }

    void print() {
        System.out.print(id + ":");
        top.print();
        right.print();
        bottom.print();
        left.print();
        System.out.println();
    }

    @Override
    public String toString() {
        return "Square [top=" + top + ", left=" + left + ", right=" + right + ", bottom=" + bottom + ", id=" + id + "]";
    }
}