package com.mycompany.firstflatlaf;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        FlatLightLaf.setup();

        SwingUtilities.invokeLater(() -> {
            BasicGUI gui = new BasicGUI();
            gui.show();
        });

    }
}
