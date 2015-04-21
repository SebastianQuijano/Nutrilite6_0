/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.JFrame;
import javax.swing.UIManager;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Sebastian
 */
public class Estilo {

    public static void tema() {
        try {
//            JFrame.setDefaultLookAndFeelDecorated(true);
//            javax.swing.UIManager.setLookAndFeel("org.jvnet.substance.skin.GreenMagicSkin");
//            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel ");     
//            frame.setDefaultLookAndFeelDecorated(true);
            JFrame.setDefaultLookAndFeelDecorated(true);
            SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.NebulaSkin");
//            SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.AutumnSkin");
//            SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY();

        } catch (Exception ex) {
            System.err.println("Error");
//            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

//    "org.jvnet.substance.skin.AutumnSkin",
//        "org.jvnet.substance.skin.BusinessBlackSteelSkin",
//        "org.jvnet.substance.skin.BusinessBlueSteelSkin",
//        "org.jvnet.substance.skin.BusinessSkin",
//        "org.jvnet.substance.skin.CremeCoffeeSkin",
//        "org.jvnet.substance.skin.c",
//        "org.jvnet.substance.skin.EmeraldDuskSkin",
//        "org.jvnet.substance.skin.FieldOfWheatSkin",
//        "org.jvnet.substance.skin.FindingNemoSkin",
//        "org.jvnet.substance.skin.GreenMagicSkin",
//        "org.jvnet.substance.skin.MagmaSkin",
//        "org.jvnet.substance.skin.MangoSkin",
//        "org.jvnet.substance.skin.MistAquaSkin",
//        "org.jvnet.substance.skin.ModerateSkin",
//        "org.jvnet.substance.skin.NebulaBrickWallSkin",
//        "org.jvnet.substance.skin.NebulaSkin",
//        "org.jvnet.substance.skin.OfficeBlue2007Skin",
//        "org.jvnet.substance.skin.OfficeSilver2007Skin",
//        "org.jvnet.substance.skin.RavenGraphiteGlassSkin",
//        "org.jvnet.substance.skin.RavenGraphiteSkin",
//        "org.jvnet.substance.skin.RavenSkin",
//        "org.jvnet.substance.skin.SaharaSkin",
}
