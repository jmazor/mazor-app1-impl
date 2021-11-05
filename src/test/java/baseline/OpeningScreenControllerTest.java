package baseline;

/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Justin Mazor
 */


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpeningScreenControllerTest {

    @Test
    void handleCreate() {
        // should create a blank file with the name in the text field
        // I am not sure how to exactly test with something in a field  but I can test the logic nontheless
    }

    @Test
    void handleOpening() {
        // should simply set filename to choice from choicebox
    }

    @Test
    void handleImport() {
        // should copy the passed file to data/persistance
        // Maybe I will create overloaded method to pass data
    }

    @Test
    void handleExport() {
        // copies data persistance to a new location
        // should be specified by the file explorer which is not implemented yet
    }
}