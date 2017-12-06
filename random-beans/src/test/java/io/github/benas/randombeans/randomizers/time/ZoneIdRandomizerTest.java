/**
 * The MIT License
 *
 *   Copyright (c) 2017, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */
package io.github.benas.randombeans.randomizers.time;

import static io.github.benas.randombeans.randomizers.time.ZoneIdRandomizer.aNewZoneIdRandomizer;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.ZoneId;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.benas.randombeans.randomizers.AbstractRandomizerTest;

public class ZoneIdRandomizerTest extends AbstractRandomizerTest<ZoneId> {

    @BeforeEach
    public void setUp() {
        randomizer = aNewZoneIdRandomizer(SEED);
    }

    @Test
    public void generatedValueShouldNotBeNull() {
        assertThat(randomizer.getRandomValue()).isNotNull();
    }

    @Test
    public void shouldGenerateTheSameValueForTheSameSeed() {
        // we can not use a canned value, because values returned by the randomizer differ between locales/jdks
        ZoneId firstZoneId = aNewZoneIdRandomizer(SEED).getRandomValue();
        ZoneId secondZoneId = aNewZoneIdRandomizer(SEED).getRandomValue();
        
        assertThat(firstZoneId).isNotNull();
        assertThat(secondZoneId).isNotNull();
        assertThat(firstZoneId).isEqualTo(secondZoneId);
    }
}