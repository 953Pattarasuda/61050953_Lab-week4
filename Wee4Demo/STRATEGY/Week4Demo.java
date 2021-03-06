import java.util.*;

class TextComposite
{
    ArrayList<TextComposite> group;
    char character;
    String colour;

    private AlignmentStrategy alignment;

    public TextComposite(AlignmentStrategy alignment)
    {
        group = new ArrayList<>();
        colour = "BLACK";
        this.alignment = alignment;
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
        System.out.println(alignment.adjustAlignment()+"["+depth+"] "+character+": colour is "+colour);
        for (TextComposite child : group)
        {
            child.print(depth + 1);
        }
    }
}

class AlignmentStrategy
{
    String alignment = "";

    String adjustAlignment()
    {
        return alignment;
    }
}

class LeftAlignmentStrategy extends AlignmentStrategy
{
    String alignment = "";

    @Override
    String adjustAlignment()
    {
        return alignment;
    }
}

class CenterAlignmentStrategy extends AlignmentStrategy
{
    String alignment = "***";

    @Override
    String adjustAlignment()
    {
        return alignment;
    }
}

class RightAlignmentStrategy extends AlignmentStrategy
{
    String alignment = "#####";

    @Override
    String adjustAlignment()
    {
        return alignment;
    }
}


class Week4Demo
{
    public static void main (String[] args)
    {
        TextComposite aPage = new TextComposite(new LeftAlignmentStrategy());
        aPage.setCharacter('A');

        TextComposite lineOne = new TextComposite(new LeftAlignmentStrategy());

        TextComposite charOne = new TextComposite(new LeftAlignmentStrategy());
        charOne.setCharacter('B');
        TextComposite charTwo = new TextComposite(new RightAlignmentStrategy());
        charTwo.setCharacter('C');
        TextComposite charThree = new TextComposite(new RightAlignmentStrategy());
        charThree.setCharacter('D');

        lineOne.add(charOne);
        lineOne.add(charTwo);
        lineOne.add(charThree);

        TextComposite charFour = new TextComposite(new CenterAlignmentStrategy());
        charFour.setCharacter('E');
        TextComposite charFive = new TextComposite(new CenterAlignmentStrategy());
        charFive.setCharacter('F');
        TextComposite groupOne = new TextComposite(new CenterAlignmentStrategy());
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





