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
package org.thingsboard.server.transport.snmp.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ScheduledTaskDiffblueTest {
  /**
   * Test {@link ScheduledTask#cancel()}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#cancel(boolean)} return
   *       {@code true}.
   *   <li>Then calls {@link ListenableFutureTask#cancel(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#cancel()}
   */
  @Test
  @DisplayName(
      "Test cancel(); given ListenableFutureTask cancel(boolean) return 'true'; then calls cancel(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScheduledTask.cancel()"})
  void testCancel_givenListenableFutureTaskCancelReturnTrue_thenCallsCancel() {
    // Arrange
    ListenableFutureTask<?> scheduledFuture = mock(ListenableFutureTask.class);
    when(scheduledFuture.cancel(anyBoolean())).thenReturn(true);

    ScheduledTask scheduledTask = new ScheduledTask();
    scheduledTask.setScheduledFuture(scheduledFuture);

    // Act
    scheduledTask.cancel();

    // Assert
    verify(scheduledFuture).cancel(true);
    assertTrue(scheduledTask.isStopped());
  }

  /**
   * Test {@link ScheduledTask#cancel()}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#cancel(boolean)} return
   *       {@code true}.
   *   <li>Then calls {@link ListenableFutureTask#cancel(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#cancel()}
   */
  @Test
  @DisplayName(
      "Test cancel(); given ListenableFutureTask cancel(boolean) return 'true'; then calls cancel(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScheduledTask.cancel()"})
  void testCancel_givenListenableFutureTaskCancelReturnTrue_thenCallsCancel2() {
    // Arrange
    ListenableFutureTask<?> scheduledFuture = mock(ListenableFutureTask.class);
    when(scheduledFuture.cancel(anyBoolean())).thenReturn(true);

    ScheduledTask scheduledTask = new ScheduledTask();
    scheduledTask.setScheduledFuture(scheduledFuture);

    // Act
    scheduledTask.cancel();

    // Assert
    verify(scheduledFuture).cancel(true);
    assertTrue(scheduledTask.isStopped());
  }

  /**
   * Test {@link ScheduledTask#cancel()}.
   *
   * <ul>
   *   <li>Given {@link ScheduledTask} (default constructor).
   *   <li>Then {@link ScheduledTask} (default constructor) Stopped.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#cancel()}
   */
  @Test
  @DisplayName(
      "Test cancel(); given ScheduledTask (default constructor); then ScheduledTask (default constructor) Stopped")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScheduledTask.cancel()"})
  void testCancel_givenScheduledTask_thenScheduledTaskStopped() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();

    // Act
    scheduledTask.cancel();

    // Assert
    assertTrue(scheduledTask.isStopped());
  }

  /**
   * Test {@link ScheduledTask#cancel()}.
   *
   * <ul>
   *   <li>Given {@link ScheduledTask} (default constructor).
   *   <li>Then {@link ScheduledTask} (default constructor) Stopped.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#cancel()}
   */
  @Test
  @DisplayName(
      "Test cancel(); given ScheduledTask (default constructor); then ScheduledTask (default constructor) Stopped")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScheduledTask.cancel()"})
  void testCancel_givenScheduledTask_thenScheduledTaskStopped2() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();

    // Act
    scheduledTask.cancel();

    // Assert
    assertTrue(scheduledTask.isStopped());
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}, and {@link ScheduledTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ScheduledTask#equals(Object)}
   *   <li>{@link ScheduledTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    ScheduledTask scheduledTask2 = new ScheduledTask();

    // Act and Assert
    assertEquals(scheduledTask, scheduledTask2);
    assertEquals(scheduledTask.hashCode(), scheduledTask2.hashCode());
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}, and {@link ScheduledTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ScheduledTask#equals(Object)}
   *   <li>{@link ScheduledTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    ScheduledTask scheduledTask2 = new ScheduledTask();

    // Act and Assert
    assertEquals(scheduledTask, scheduledTask2);
    assertEquals(scheduledTask.hashCode(), scheduledTask2.hashCode());
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}, and {@link ScheduledTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ScheduledTask#equals(Object)}
   *   <li>{@link ScheduledTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();

    // Act and Assert
    assertEquals(scheduledTask, scheduledTask);
    int expectedHashCodeResult = scheduledTask.hashCode();
    assertEquals(expectedHashCodeResult, scheduledTask.hashCode());
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}, and {@link ScheduledTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ScheduledTask#equals(Object)}
   *   <li>{@link ScheduledTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual2() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();

    // Act and Assert
    assertEquals(scheduledTask, scheduledTask);
    int expectedHashCodeResult = scheduledTask.hashCode();
    assertEquals(expectedHashCodeResult, scheduledTask.hashCode());
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ScheduledTask(), 1);
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    scheduledTask.setStopped(true);

    // Act and Assert
    assertNotEquals(scheduledTask, new ScheduledTask());
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    SettableFuture<?> delegate = SettableFuture.create();
    ForwardingApiFuture<?> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    scheduledTask.setScheduledFuture(new ApiFutureToListenableFuture<>(apiFuture));

    // Act and Assert
    assertNotEquals(scheduledTask, new ScheduledTask());
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange, Act and Assert
    assertNotEquals(new ScheduledTask(), 1);
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    scheduledTask.setStopped(true);

    // Act and Assert
    assertNotEquals(scheduledTask, new ScheduledTask());
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ScheduledTask scheduledTask = new ScheduledTask();
    SettableFuture<?> delegate = SettableFuture.create();
    ForwardingApiFuture<?> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    scheduledTask.setScheduledFuture(new ApiFutureToListenableFuture<>(apiFuture));

    // Act and Assert
    assertNotEquals(scheduledTask, new ScheduledTask());
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ScheduledTask(), null);
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ScheduledTask(), null);
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ScheduledTask(), "Different type to ScheduledTask");
  }

  /**
   * Test {@link ScheduledTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScheduledTask.equals(Object)", "int ScheduledTask.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ScheduledTask(), "Different type to ScheduledTask");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ScheduledTask}
   *   <li>{@link ScheduledTask#setStopped(boolean)}
   *   <li>{@link ScheduledTask#toString()}
   *   <li>{@link ScheduledTask#getScheduledFuture()}
   *   <li>{@link ScheduledTask#isStopped()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScheduledTask.<init>()",
    "ListenableFuture ScheduledTask.getScheduledFuture()",
    "boolean ScheduledTask.isStopped()",
    "void ScheduledTask.setScheduledFuture(ListenableFuture)",
    "void ScheduledTask.setStopped(boolean)",
    "String ScheduledTask.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ScheduledTask actualScheduledTask = new ScheduledTask();
    actualScheduledTask.setStopped(true);
    String actualToStringResult = actualScheduledTask.toString();
    ListenableFuture<?> actualScheduledFuture = actualScheduledTask.getScheduledFuture();

    // Assert
    assertEquals("ScheduledTask(scheduledFuture=null, stopped=true)", actualToStringResult);
    assertNull(actualScheduledFuture);
    assertTrue(actualScheduledTask.isStopped());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ScheduledTask}
   *   <li>{@link ScheduledTask#setStopped(boolean)}
   *   <li>{@link ScheduledTask#toString()}
   *   <li>{@link ScheduledTask#getScheduledFuture()}
   *   <li>{@link ScheduledTask#isStopped()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScheduledTask.<init>()",
    "ListenableFuture ScheduledTask.getScheduledFuture()",
    "boolean ScheduledTask.isStopped()",
    "void ScheduledTask.setScheduledFuture(ListenableFuture)",
    "void ScheduledTask.setStopped(boolean)",
    "String ScheduledTask.toString()"
  })
  void testGettersAndSetters2() {
    // Arrange and Act
    ScheduledTask actualScheduledTask = new ScheduledTask();
    actualScheduledTask.setStopped(true);
    String actualToStringResult = actualScheduledTask.toString();
    ListenableFuture<?> actualScheduledFuture = actualScheduledTask.getScheduledFuture();

    // Assert
    assertEquals("ScheduledTask(scheduledFuture=null, stopped=true)", actualToStringResult);
    assertNull(actualScheduledFuture);
    assertTrue(actualScheduledTask.isStopped());
  }
}
