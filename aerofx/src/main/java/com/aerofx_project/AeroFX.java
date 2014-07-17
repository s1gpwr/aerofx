/*
 * Copyright (c) 2014, Matthias Meidinger
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies,
 * either expressed or implied, of the FreeBSD Project.
 */

package com.aerofx_project;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;

/**
 * Created by Matthias on 27.05.2014.
 */
public class AeroFX {
    private final static String AERO_CSS_NAME = AeroFX.class.getResource("win7.css").toExternalForm();

    public static void style(){
        Application.setUserAgentStylesheet(AERO_CSS_NAME);
    }

    public static void styleGroupBox(TitledPane p){
        p.getStyleClass().clear();
        p.getStyleClass().add("group-box");
    }

    public static void styleAllAsGroupbox(Parent p){
            for(Node a : p.getChildrenUnmodifiable()){
                if(a instanceof TitledPane) {
                    styleGroupBox((TitledPane) a);
                } else if(a instanceof TabPane) {
                    for(Tab t : ((TabPane)a).getTabs()) {
                        Node content = t.getContent();
                        if(content != null && content instanceof Parent) {
                            styleAllAsGroupbox((Parent) content);
                        }
                    }
                }
                else if(a instanceof Parent) {
                    styleAllAsGroupbox((Parent) a);
                }
            }
    }
}