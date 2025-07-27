import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField tfname, tfphone, tfaadhaar, tfnationality, tfaddress;
    JRadioButton rbmale, rbfemale;

    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(160,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblname = new JLabel("NAME : ");
        lblname.setBounds(60,80,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220,80,150,25);
        add(tfname);

        JLabel lblnationality = new JLabel("NATIONALITY : ");
        lblnationality.setBounds(60,130,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationality);

        tfnationality = new JTextField();
        tfnationality.setBounds(220,130,150,25);
        add(tfnationality);

        JLabel lblaadhaar = new JLabel("AADHAAR : ");
        lblaadhaar.setBounds(60,180,150,25);
        lblaadhaar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhaar);

        tfaadhaar = new JTextField();
        tfaadhaar.setBounds(220,180,150,25);
        add(tfaadhaar);

        JLabel lbladdress = new JLabel("ADDRESS : ");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220,230,150,25);
        add(tfaddress);

        JLabel lblgender = new JLabel("GENDER : ");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);

        ButtonGroup gendergroup = new ButtonGroup();

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220,280,70,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300,280,70,25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);

        JLabel lblphone = new JLabel("PHONE NUMBER : ");
        lblphone.setBounds(60,330,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);

        JButton save = new JButton("SAVE");
        save.setBackground(Color.black);
        save.setForeground(Color.white);
        save.setBounds(220,380,150,30);
        save.addActionListener(this);
        add(save);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/emp.png"));
        Image scaled = icon.getImage().getScaledInstance(250, 240, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaled);
        JLabel lblimage = new JLabel(resizedIcon);
        lblimage.setBounds(480, 100, 160, 240);
        add(lblimage);




        setSize(700,500);
        setLocation(300,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhaar = tfaadhaar.getText();
        String gender = null;
        if (rbmale.isSelected()){
            gender= "Male";

        }else {
            gender = "Female";
        }

        try {
            Conn conn = new Conn();

            String query = "Insert into passenger values('"+name+"','"+nationality+"','"+phone+"', '"+address+"', '"+aadhaar+"', '"+gender+"')";

            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");

            setVisible(false);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new AddCustomer();

    }
}

