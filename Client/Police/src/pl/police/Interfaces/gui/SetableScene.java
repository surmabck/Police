/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.Interfaces.gui;

import javafx.scene.Node;
import javafx.scene.Scene;

/**
 *
 * @author Bartosz
 */
public interface SetableScene extends Setable {

    public void setNode(Node node);

    public Node getNode();
}
