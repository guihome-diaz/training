package ep.dgtrad.util.diffing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ep.dgtrad.util.diffing.util.FileUtils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Dialogs;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class RootPaneController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RootPaneController.class);

	@FXML
	MenuItem openItem, saveItem, quitItem;
	@FXML
	MenuItem aboutItem;

	public void openFile() {
		// Setup file chooser
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open text file");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		ExtensionFilter txtFileFilter = new ExtensionFilter("Text file", "*.txt");
		fileChooser.getExtensionFilters().add(txtFileFilter);

		// Show open file dialog
		File file = fileChooser.showOpenDialog(App.getInstance().getPrimaryStage());
		if (file != null) {
			LOGGER.info("User wants to load TXT file: " + file.getPath());
			// FIXME populate content
			List<String> original = new ArrayList<>();
			List<String> revised = new ArrayList<>();
			FileUtils.readDiffingFile(file, original, revised);
			DiffingController.getInstance().initSourceContent(original, revised);
		} else {
			LOGGER.info("Operation cancelled, user did not load any TXT file!");
		}
	}

	public void exitApplication() {
		Platform.exit();
	}

	public void aboutPopup() {
		// TODO remove that code once migration to Java 8.40+ will be effective
		// JavaFX doesn't include Popup supports until Java8.40 ... In the meantime you must use a 3rd party dialog library.
		// I'm using http://code.makery.ch/blog/javafx-2-dialogs/
		// You'll find the library usage on the website.

		Dialogs.showInformationDialog(App.getInstance().getPrimaryStage(), "v1.0 - 2016/05 - Cat4trad team", "About DIFFING application", "About");
	}
}
