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

package io.apicurio.datamodels.asyncapi.models;

import java.util.List;

import io.apicurio.datamodels.asyncapi.visitors.IAaiVisitor;
import io.apicurio.datamodels.core.models.Node;
import io.apicurio.datamodels.core.models.common.ServerVariable;
import io.apicurio.datamodels.core.visitors.IVisitor;

/**
 * @author eric.wittmann@gmail.com
 * @author Jakub Senko <jsenko@redhat.com>
 */
public abstract class AaiServerVariable extends ServerVariable {

    public List<String> examples;
    
    /**
     * Constructor.
     */
    public AaiServerVariable(String name) {
        super(name);
    }

    /**
     * Constructor.
     * @param parent
     * @param name
     */
    public AaiServerVariable(Node parent, String name) {
        super(name);
        if(parent != null) {
            this._parent = parent;
            this._ownerDocument = parent.ownerDocument();
        }
    }

    /**
     * Constructor.
     * @param parent
     */
    public AaiServerVariable(Node parent) {
        this(parent, null);
    }

    /**
     * @see io.apicurio.datamodels.core.models.Node#accept(IVisitor)
     */
    @Override
    public void accept(IVisitor visitor) {
        IAaiVisitor viz = (IAaiVisitor) visitor;
        viz.visitServerVariable(this);
    }

}
