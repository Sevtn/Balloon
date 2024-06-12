module cz.spsmb.dominick.fxfirst2dgraphicsbasics {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens cz.spsmb.dominick.fxfirst2dgraphicsbasics to javafx.fxml;
    exports cz.spsmb.dominick.fxfirst2dgraphicsbasics;
}