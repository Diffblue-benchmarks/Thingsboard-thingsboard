/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
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
package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.kv.AggTsKvEntry;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.IncorrectParameterException;

public class KvUtilsDiffblueTest {
  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation() {
    // Arrange
    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new JsonDataEntry("Key", "42"));

    // Act and Assert
    KvUtils.validate(tsKvEntries, true);
  }

  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation2() {
    // Arrange
    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new JsonDataEntry("Key", "42"));
    tsKvEntries.add(new JsonDataEntry("Key", "42"));

    // Act and Assert
    KvUtils.validate(tsKvEntries, true);
  }

  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation3() {
    // Arrange
    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new JsonDataEntry(null, "42"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> KvUtils.validate(tsKvEntries, true));
  }

  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation4() {
    // Arrange
    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new JsonDataEntry("42", "42"));

    // Act and Assert
    KvUtils.validate(tsKvEntries, true);
  }

  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation5() {
    // Arrange
    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new JsonDataEntry("", "42"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> KvUtils.validate(tsKvEntries, true));
  }

  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation6() {
    // Arrange
    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    JsonDataEntry jsonDataEntry = new JsonDataEntry("Key", null);
    tsKvEntries.add(jsonDataEntry);

    // Act and Assert
    KvUtils.validate(tsKvEntries, true);
  }

  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation7() {
    // Arrange
    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new JsonDataEntry("Key", ""));

    // Act and Assert
    KvUtils.validate(tsKvEntries, true);
  }

  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code
   * valueNoXssValidation}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation_givenNull_whenArrayListAddNull() {
    // Arrange
    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(null);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> KvUtils.validate(tsKvEntries, true));
  }

  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code
   * valueNoXssValidation}.
   *
   * <ul>
   *   <li>Then calls {@link AggTsKvEntry#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation_thenCallsGetKey() {
    // Arrange
    AggTsKvEntry aggTsKvEntry = mock(AggTsKvEntry.class);
    when(aggTsKvEntry.getKey()).thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(aggTsKvEntry);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> KvUtils.validate(tsKvEntries, true));
    verify(aggTsKvEntry).getKey();
  }

  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code
   * valueNoXssValidation}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation_whenArrayList_thenDoesNotThrow() {
    // Arrange, Act and Assert
    KvUtils.validate(new ArrayList<>(), true);
  }

  /**
   * Test {@link KvUtils#validate(List, boolean)} with {@code tsKvEntries}, {@code
   * valueNoXssValidation}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then calls {@link AggTsKvEntry#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link KvUtils#validate(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(List, boolean)"})
  public void testValidateWithTsKvEntriesValueNoXssValidation_whenFalse_thenCallsGetKey() {
    // Arrange
    AggTsKvEntry aggTsKvEntry = mock(AggTsKvEntry.class);
    when(aggTsKvEntry.getKey()).thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<KvEntry> tsKvEntries = new ArrayList<>();
    tsKvEntries.add(new JsonDataEntry("Key", "42"));
    tsKvEntries.add(aggTsKvEntry);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> KvUtils.validate(tsKvEntries, false));
    verify(aggTsKvEntry).getKey();
  }

  /**
   * Test {@link KvUtils#validate(KvEntry, boolean)} with {@code tsKvEntry}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(KvEntry, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(KvEntry, boolean)"})
  public void testValidateWithTsKvEntryValueNoXssValidation() {
    // Arrange, Act and Assert
    KvUtils.validate(new JsonDataEntry("Key", "42"), true);
  }

  /**
   * Test {@link KvUtils#validate(KvEntry, boolean)} with {@code tsKvEntry}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(KvEntry, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(KvEntry, boolean)"})
  public void testValidateWithTsKvEntryValueNoXssValidation2() {
    // Arrange, Act and Assert
    KvUtils.validate(new BooleanDataEntry("Key", true), false);
  }

  /**
   * Test {@link KvUtils#validate(KvEntry, boolean)} with {@code tsKvEntry}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(KvEntry, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(KvEntry, boolean)"})
  public void testValidateWithTsKvEntryValueNoXssValidation3() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class, () -> KvUtils.validate((KvEntry) null, false));
  }

  /**
   * Test {@link KvUtils#validate(KvEntry, boolean)} with {@code tsKvEntry}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(KvEntry, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(KvEntry, boolean)"})
  public void testValidateWithTsKvEntryValueNoXssValidation4() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class, () -> KvUtils.validate(new JsonDataEntry(null, "42"), true));
  }

  /**
   * Test {@link KvUtils#validate(KvEntry, boolean)} with {@code tsKvEntry}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(KvEntry, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(KvEntry, boolean)"})
  public void testValidateWithTsKvEntryValueNoXssValidation5() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class, () -> KvUtils.validate(new JsonDataEntry("", "42"), true));
  }

  /**
   * Test {@link KvUtils#validate(KvEntry, boolean)} with {@code tsKvEntry}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(KvEntry, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(KvEntry, boolean)"})
  public void testValidateWithTsKvEntryValueNoXssValidation6() {
    // Arrange
    JsonDataEntry tsKvEntry = new JsonDataEntry("Key", null);

    // Act and Assert
    KvUtils.validate(tsKvEntry, true);
  }

  /**
   * Test {@link KvUtils#validate(KvEntry, boolean)} with {@code tsKvEntry}, {@code
   * valueNoXssValidation}.
   *
   * <p>Method under test: {@link KvUtils#validate(KvEntry, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void KvUtils.validate(KvEntry, boolean)"})
  public void testValidateWithTsKvEntryValueNoXssValidation7() {
    // Arrange, Act and Assert
    KvUtils.validate(new JsonDataEntry("Key", ""), true);
  }
}
