/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.facebook.presto.plugin.blackhole;

import com.facebook.presto.spi.ConnectorTableLayoutHandle;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public final class BlackHoleTableLayoutHandle
        implements ConnectorTableLayoutHandle
{
    private final int splitsCount;
    private final int pagesPerSplit;
    private final int rowsPerPage;

    @JsonCreator
    public BlackHoleTableLayoutHandle(
            @JsonProperty("splitsCount") int splitsCount,
            @JsonProperty("pagesPerSplit") int pagesPerSplit,
            @JsonProperty("rowsPerPage") int rowsPerPage)
    {
        this.splitsCount = splitsCount;
        this.pagesPerSplit = pagesPerSplit;
        this.rowsPerPage = rowsPerPage;
    }

    @JsonProperty
    public int getSplitsCount()
    {
        return splitsCount;
    }

    @JsonProperty
    public int getPagesPerSplit()
    {
        return pagesPerSplit;
    }

    @JsonProperty
    public int getRowsPerPage()
    {
        return rowsPerPage;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getSplitsCount(), getPagesPerSplit(), getRowsPerPage());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BlackHoleTableLayoutHandle other = (BlackHoleTableLayoutHandle) obj;
        return Objects.equals(this.getSplitsCount(), other.getSplitsCount()) &&
                Objects.equals(this.getPagesPerSplit(), other.getPagesPerSplit()) &&
                Objects.equals(this.getRowsPerPage(), other.getRowsPerPage());
    }
}
