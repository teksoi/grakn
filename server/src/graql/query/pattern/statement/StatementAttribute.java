/*
 * GRAKN.AI - THE KNOWLEDGE GRAPH
 * Copyright (C) 2018 Grakn Labs Ltd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package grakn.core.graql.query.pattern.statement;

import grakn.core.graql.query.pattern.property.VarProperty;

import javax.annotation.CheckReturnValue;
import java.util.LinkedHashSet;

/**
 * A Graql statement describe a Attribute
 */
public class StatementAttribute extends StatementInstance {

    private StatementAttribute(Statement statement) {
        this(statement.var(), statement.properties());
    }

    StatementAttribute(Variable var, LinkedHashSet<VarProperty> properties) {
        super(var, properties);
    }

    public static grakn.core.graql.query.pattern.statement.StatementAttribute create(Statement statement, VarProperty varProperty) {
        if (statement instanceof grakn.core.graql.query.pattern.statement.StatementAttribute) {
            return ((grakn.core.graql.query.pattern.statement.StatementAttribute) statement).addProperty(varProperty);

        } else if (!(statement instanceof StatementRelation)
                && !(statement instanceof StatementType)) {
            return new grakn.core.graql.query.pattern.statement.StatementAttribute(statement).addProperty(varProperty);

        } else {
            throw illegalArgumentException(statement, varProperty);
        }
    }

    @CheckReturnValue
    private grakn.core.graql.query.pattern.statement.StatementAttribute addProperty(VarProperty property) {
        validateNoConflictOrThrow(property);
        LinkedHashSet<VarProperty> newProperties = new LinkedHashSet<>(this.properties());
        newProperties.add(property);
        return new grakn.core.graql.query.pattern.statement.StatementAttribute(this.var(), newProperties);
    }
}