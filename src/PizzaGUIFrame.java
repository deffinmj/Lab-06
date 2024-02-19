import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PizzaGUIFrame extends JFrame
{
    JPanel mainPnl;
    JPanel radioPnl;
    JPanel checkPnl;
    JPanel comboPnl;
    JPanel orderPnl;
    JPanel controlPnl;

    JRadioButton thinCrustRB;
    JRadioButton regularCrustRB;
    JRadioButton deepDishCrustRB;

    JComboBox sizeCB;

    JCheckBox pepperoniCB;
    JCheckBox sausageCB;
    JCheckBox mushroomsCB;
    JCheckBox olivesCB;
    JCheckBox extraSauceCB;
    JCheckBox extraCheeseCB;

    JTextArea orderTA;
    JScrollPane scroller;

    JButton quitBtn;
    JButton clearBtn;
    JButton displayChoicesBtn;

    public PizzaGUIFrame()
    {
        mainPnl = new JPanel();
        JPanel upperPnl = new JPanel();
        upperPnl.setLayout(new GridLayout(3,1));

        createRadioPanel();
        upperPnl.add(radioPnl);

        createComboPanel();
        upperPnl.add(comboPnl);

        createCheckPanel();
        upperPnl.add(checkPnl);
        mainPnl.add(upperPnl);

        JPanel lowerPnl = new JPanel();
        lowerPnl.setLayout(new GridLayout(2,1));
        createOrderPanel();
        lowerPnl.add(orderPnl);

        createControlPanel();
        lowerPnl.add(controlPnl);
        mainPnl.add(lowerPnl);

        add(mainPnl);
        setSize(500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createComboPanel()
    {
        comboPnl = new JPanel();
        comboPnl.setBorder(new TitledBorder(new EtchedBorder(),"Pizza Size"));

        sizeCB = new JComboBox();
        sizeCB.addItem("Small");
        sizeCB.addItem("Medium");
        sizeCB.addItem("Large");
        sizeCB.addItem("Super");
        comboPnl.add(sizeCB);

    }

    private void createRadioPanel()
    {
        radioPnl = new JPanel();
        radioPnl.setLayout(new GridLayout(1, 4));
        radioPnl.setBorder(new TitledBorder(new EtchedBorder(),"Crust Type"));


        thinCrustRB  = new JRadioButton("Thin");
        regularCrustRB = new JRadioButton("Regular");
        deepDishCrustRB  = new JRadioButton("Deep Dish");

        radioPnl.add(thinCrustRB);
        radioPnl.add(regularCrustRB);
        radioPnl.add(deepDishCrustRB);

        regularCrustRB.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(thinCrustRB);
        group.add(regularCrustRB);
        group.add(deepDishCrustRB);


    }

    private void createCheckPanel()
    {
        checkPnl = new JPanel();
        checkPnl.setLayout(new GridLayout(2,4));
        checkPnl.setBorder(new TitledBorder(new EtchedBorder(),"Toppings"));

        pepperoniCB = new JCheckBox("Pepperoni");
        sausageCB = new JCheckBox("Sausage");
        mushroomsCB = new JCheckBox("Mushrooms");
        olivesCB = new JCheckBox("Olives");
        extraSauceCB = new JCheckBox("Extra Sauce");
        extraCheeseCB = new JCheckBox("Extra Cheese");

        checkPnl.add(pepperoniCB);
        checkPnl.add(sausageCB);
        checkPnl.add(mushroomsCB);
        checkPnl.add(olivesCB);
        checkPnl.add(extraSauceCB);
        checkPnl.add(extraCheeseCB);

    }

    private void createOrderPanel()
    {
        orderPnl = new JPanel();
        orderPnl.setBorder(new TitledBorder(new EtchedBorder(),"Order"));
        orderTA = new JTextArea(10, 25);
        orderTA.setEditable(false);
        scroller = new JScrollPane(orderTA);
        orderPnl.add(scroller);
    }

    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setBorder(new TitledBorder(new EtchedBorder(),"Controls"));

        displayChoicesBtn = new JButton("Order");
        displayChoicesBtn.addActionListener(
                (ActionEvent ae) ->
                {
                    // Generate a result string and then display it with a Message Diaplog
                    double total = 0;
                    String res ="Form Details\n";
                    // get the size choice
                    res += "Crust type: ";
                    if(thinCrustRB.isSelected())
                        res += "Thin\n";
                    else if(regularCrustRB.isSelected())
                        res += "Regular\n";
                    else if(deepDishCrustRB.isSelected())
                        res += "Deep Dish\n";
                    // get the items

                    res += "\tPizza Size: ";
                    if (sizeCB.getSelectedItem() == "Small") {
                        res += "Small\n";
                        total+=8;
                    } else if(sizeCB.getSelectedItem() == "Medium") {
                        res += "Medium\n";
                        total+=12;
                    } else if(sizeCB.getSelectedItem() == "Large") {
                        res += "Large\n";
                        total+=16;
                    } else if(sizeCB.getSelectedItem() == "Super") {
                        res += "Super\n";
                        total+=20;
                    }

                    res += "With these gourmet toppings:\n";
                    if (pepperoniCB.isSelected()) {
                        res += "\tPepperoni\n";
                        total += 1;
                    }
                    if (sausageCB.isSelected()) {
                        res += "\tSausage\n";
                        total += 1;
                    }
                    if (mushroomsCB.isSelected()) {
                        res += "\tMushrooms\n";
                        total+=1;
                    }

                    if (olivesCB.isSelected()) {
                        res += "\tOlives\n";
                        total += 1;
                    }
                    if (extraSauceCB.isSelected()) {
                        res += "\tExtra Sauce\n";
                        total += 1;
                    }
                    if (extraCheeseCB.isSelected()) {
                        res += "\tExtra Cheese\n";
                        total += 1;
                    }
                    res += "\n";
                    res += "Sub-total: " + Double.toString(total);
                    res += "\n";
                    double tax = total * .07;
                    res += "Tax: " + Double.toString(tax);
                    res += "\n";
                    res += "\n";
                    res += "Total: " + Double.toString(total + tax);
                    // get the home
                    orderTA.setText(res);
                }
        );

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        quitBtn = new JButton("Quit!");
        quitBtn.addActionListener((ActionEvent ae) -> {
            if(JOptionPane.showOptionDialog(null, "Are you sure you want to quit?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == 0) {
                System.exit(0);
            }
        });

        controlPnl.add(displayChoicesBtn);
        controlPnl.add(clearBtn);
        controlPnl.add(quitBtn);

    }
}
