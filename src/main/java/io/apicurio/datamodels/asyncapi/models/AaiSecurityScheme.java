package io.apicurio.datamodels.asyncapi.models;

import io.apicurio.datamodels.core.models.IReferenceNode;
import io.apicurio.datamodels.core.models.Node;
import io.apicurio.datamodels.core.models.common.IDefinition;
import io.apicurio.datamodels.core.models.common.SecurityScheme;

/**
 * @author Jakub Senko <jsenko@redhat.com>
 */
public abstract class AaiSecurityScheme extends SecurityScheme implements IReferenceNode, IDefinition {

    public String $ref;
    public String scheme;
    public AaiOAuthFlows flows;
    public String openIdConnectUrl;
    public String bearerFormat;

    /**
     * Constructor.
     */
    public AaiSecurityScheme(String name) {
        super(name);
    }
    
    public AaiSecurityScheme(Node parent) {
        this(parent, null);
    }

    public AaiSecurityScheme(Node parent, String name) {
        super(name);
        if(parent != null) {
            this._parent = parent;
            this._ownerDocument = parent.ownerDocument();
        }
    }

    @Override
    public String getReference() {
        return $ref;
    }

    @Override
    public void setReference(String reference) {
        $ref = reference;
    }
}
