module com.aumzaveri.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.aumzaveri.tictactoe to javafx.fxml;
    exports com.aumzaveri.tictactoe;
    exports com.aumzaveri.Controller;
    opens com.aumzaveri.Controller to javafx.fxml;
}