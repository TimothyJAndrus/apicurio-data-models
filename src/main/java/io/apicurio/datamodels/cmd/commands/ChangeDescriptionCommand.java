/*
 * Copyright 2019 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.datamodels.cmd.commands;

import io.apicurio.datamodels.cmd.AbstractCommand;
import io.apicurio.datamodels.cmd.util.ModelUtils;
import io.apicurio.datamodels.compat.LoggerCompat;
import io.apicurio.datamodels.core.models.Document;

/**
 * A command used to modify the description of a document.
 * @author eric.wittmann@gmail.com
 */
public class ChangeDescriptionCommand extends AbstractCommand {
    
    public String _newDescription;

    public String _oldDescription;
    public boolean _nullInfo;
    
    /**
     * Constructor.
     */
    ChangeDescriptionCommand() {
    }
    
    /**
     * Constructor.
     * @param newDescription
     */
    ChangeDescriptionCommand(String newDescription) {
        this._newDescription = newDescription;
    }
    
    /**
     * @see io.apicurio.datamodels.cmd.ICommand#execute(io.apicurio.datamodels.core.models.Document)
     */
    @Override
    public void execute(Document document) {
        LoggerCompat.info("[ChangeDescriptionCommand] Executing.");
        if (ModelUtils.isNullOrUndefined(document.info)) {
            document.info = document.createInfo();
            this._nullInfo = true;
            this._oldDescription = null;
        } else {
            this._oldDescription = document.info.description;
        }
        document.info.description = this._newDescription;
    }
    
    /**
     * @see io.apicurio.datamodels.cmd.ICommand#undo(io.apicurio.datamodels.core.models.Document)
     */
    @Override
    public void undo(Document document) {
        LoggerCompat.info("[ChangeDescriptionCommand] Reverting.");
        if (this._nullInfo) {
            document.info = null;
        } else {
            document.info.description = this._oldDescription;
        }
    }

}
