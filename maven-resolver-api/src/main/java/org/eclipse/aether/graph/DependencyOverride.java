package org.eclipse.aether.graph;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.eclipse.aether.artifact.Artifact;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * A dependency override, containing coordinates of the original dependency and the override.
 * <em>Note:</em> Instances of this class are immutable and the exposed mutators return new objects rather than changing
 * the current instance.
 */
public final class DependencyOverride
{

    private final Artifact original;

    private final Artifact override;

    public DependencyOverride( Artifact original, Artifact override )
    {
        this.original = requireNonNull( original, "original must not be null" );
        this.override = requireNonNull( override, "override must not be null" );
    }

    public Artifact getOriginal()
    {
        return original;
    }

    public DependencyOverride setOriginal( Artifact original )
    {
        if ( this.original.equals( original ) )
        {
            return this;
        }
        return new DependencyOverride( original, override );
    }

    public Artifact getOverride()
    {
        return override;
    }

    public DependencyOverride setOverride( Artifact override )
    {
        if ( this.override.equals( override ) )
        {
            return this;
        }
        return new DependencyOverride( original, override );
    }

    @Override
    public String toString()
    {
        return getOriginal() + " -> " + getOverride();
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( obj == this )
        {
            return true;
        }
        else if ( obj == null || !getClass().equals( obj.getClass() ) )
        {
            return false;
        }

        DependencyOverride that = (DependencyOverride) obj;

        return Objects.equals( original, that.original ) && Objects.equals( override, that.override );
    }

    @Override
    public int hashCode()
    {
        int hash = 17;
        hash = hash * 31 + original.hashCode();
        hash = hash * 31 + override.hashCode();
        return hash;
    }

}
