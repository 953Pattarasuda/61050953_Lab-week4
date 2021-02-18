import java.util.*;

class Week4Demo
{
    public static void main (String[] args)
    {
        TextComposite aPage = new TextComposite();
        aPage.setCharacter('A');

        TextComposite lineOne = new TextComposite();

        TextComposite charOne = new TextComposite();
        charOne.setCharacter('B');
        TextComposite charTwo = new TextComposite();
        charTwo.setCharacter('C');
        TextComposite charThree = new TextComposite();
        charThree.setCharacter('D');

        lineOne.add(charOne);
        lineOne.add(charTwo);
        lineOne.add(charThree);

        TextComposite charFour = new TextComposite();
        charFour.setCharacter('E');
        TextComposite charFive = new TextComposite();
        charFive.setCharacter('F');
        TextComposite groupOne = new TextComposite();
        groupOne.add(charFour);
        groupOne.add(charFive);

        lineOne.add(groupOne);

        aPage.add(lineOne);

        aPage.print(0);
        System.out.println();

        groupOne.setColour("RED");
        aPage.print(0);
        System.out.println();

        aPage.setColour("GREEN");
        aPage.print(0);
        System.out.println();
    }
}

class TextComposite
{
    ArrayList<TextComposite> group;
    char character;
    String colour;

    public TextComposite()
    {
        group = new ArrayList<>();
        colour = "BLACK";
    }

    public void setCharacter(char aChar)
    {
        character = aChar;
    }

    public char getCharacter()
    {
        return character;
    }

    public void setColour(String newColour)
    {
        colour = newColour;
        for (TextComposite child : group)
        {
            child.setColour(newColour);
        }
    }

    public void add(TextComposite child)
    {
        group.add(child);
    }

    public TextComposite getChild(int index)
    {
        return group.get(index);
    }

    public void print(int depth)
    {
        System.out.println("["+depth+"] "+character+": colour is "+colour);
        for (TextComposite child : group)
        {
            child.print(depth + 1);
        }
    }
}



