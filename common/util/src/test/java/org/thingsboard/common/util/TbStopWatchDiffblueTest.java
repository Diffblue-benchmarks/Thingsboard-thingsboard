package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

class TbStopWatchDiffblueTest {
  /**
   * Test {@link TbStopWatch#create()}.
   *
   * <p>Method under test: {@link TbStopWatch#create()}
   */
  @Test
  @DisplayName("Test create()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbStopWatch TbStopWatch.create()"})
  void testCreate() {
    // Arrange and Act
    TbStopWatch actualCreateResult = TbStopWatch.create();

    // Assert
    assertEquals("", actualCreateResult.currentTaskName());
    assertEquals("", actualCreateResult.getId());
    assertEquals(0, actualCreateResult.getTaskCount());
    assertEquals(0, actualCreateResult.getTaskInfo().length);
    assertEquals(0.0d, actualCreateResult.getTotalTimeSeconds());
    assertEquals(0L, actualCreateResult.getTotalTimeMillis());
    assertEquals(0L, actualCreateResult.getTotalTimeNanos());
    assertTrue(actualCreateResult.isRunning());
  }

  /**
   * Test {@link TbStopWatch#create(String)} with {@code String}.
   *
   * <p>Method under test: {@link TbStopWatch#create(String)}
   */
  @Test
  @DisplayName("Test create(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbStopWatch TbStopWatch.create(String)"})
  void testCreateWithString() {
    // Arrange and Act
    TbStopWatch actualCreateResult = TbStopWatch.create("Task Name");

    // Assert
    assertEquals("", actualCreateResult.getId());
    assertEquals("Task Name", actualCreateResult.currentTaskName());
    assertEquals(0, actualCreateResult.getTaskCount());
    assertEquals(0, actualCreateResult.getTaskInfo().length);
    assertEquals(0.0d, actualCreateResult.getTotalTimeSeconds());
    assertEquals(0L, actualCreateResult.getTotalTimeMillis());
    assertEquals(0L, actualCreateResult.getTotalTimeNanos());
    assertTrue(actualCreateResult.isRunning());
  }

  /**
   * Test {@link TbStopWatch#startNew(String)}.
   *
   * <ul>
   *   <li>Given create.
   *   <li>Then create LastTaskName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbStopWatch#startNew(String)}
   */
  @Test
  @DisplayName("Test startNew(String); given create; then create LastTaskName is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbStopWatch.startNew(String)"})
  void testStartNew_givenCreate_thenCreateLastTaskNameIsEmptyString() throws IllegalStateException {
    // Arrange
    TbStopWatch createResult = TbStopWatch.create();

    // Act
    createResult.startNew("Task Name");

    // Assert
    assertEquals("", createResult.getLastTaskName());
    TaskInfo lastTaskInfo = createResult.getLastTaskInfo();
    assertEquals("", lastTaskInfo.getTaskName());
    assertEquals("Task Name", createResult.currentTaskName());
    assertEquals(0L, createResult.getLastTaskTimeMillis());
    assertEquals(0L, lastTaskInfo.getTimeMillis());
    assertEquals(1, createResult.getTaskCount());
    TaskInfo[] taskInfo = createResult.getTaskInfo();
    assertEquals(1, taskInfo.length);
    assertSame(lastTaskInfo, taskInfo[0]);
  }

  /**
   * Test {@link TbStopWatch#stopAndGetTotalTimeMillis()}.
   *
   * <ul>
   *   <li>Given create.
   *   <li>Then create LastTaskName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbStopWatch#stopAndGetTotalTimeMillis()}
   */
  @Test
  @DisplayName(
      "Test stopAndGetTotalTimeMillis(); given create; then create LastTaskName is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TbStopWatch.stopAndGetTotalTimeMillis()"})
  void testStopAndGetTotalTimeMillis_givenCreate_thenCreateLastTaskNameIsEmptyString()
      throws IllegalStateException {
    // Arrange
    TbStopWatch createResult = TbStopWatch.create();

    // Act
    long actualStopAndGetTotalTimeMillisResult = createResult.stopAndGetTotalTimeMillis();

    // Assert
    assertEquals("", createResult.getLastTaskName());
    TaskInfo lastTaskInfo = createResult.getLastTaskInfo();
    assertEquals("", lastTaskInfo.getTaskName());
    assertNull(createResult.currentTaskName());
    assertEquals(0L, createResult.getLastTaskTimeMillis());
    assertEquals(0L, lastTaskInfo.getTimeMillis());
    assertEquals(0L, actualStopAndGetTotalTimeMillisResult);
    assertEquals(1, createResult.getTaskCount());
    TaskInfo[] taskInfo = createResult.getTaskInfo();
    assertEquals(1, taskInfo.length);
    assertFalse(createResult.isRunning());
    assertSame(lastTaskInfo, taskInfo[0]);
  }

  /**
   * Test {@link TbStopWatch#stopAndGetTotalTimeNanos()}.
   *
   * <ul>
   *   <li>Given create.
   *   <li>Then create LastTaskName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbStopWatch#stopAndGetTotalTimeNanos()}
   */
  @Test
  @DisplayName(
      "Test stopAndGetTotalTimeNanos(); given create; then create LastTaskName is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TbStopWatch.stopAndGetTotalTimeNanos()"})
  void testStopAndGetTotalTimeNanos_givenCreate_thenCreateLastTaskNameIsEmptyString()
      throws IllegalStateException {
    // Arrange
    TbStopWatch createResult = TbStopWatch.create();

    // Act
    createResult.stopAndGetTotalTimeNanos();

    // Assert
    assertEquals("", createResult.getLastTaskName());
    TaskInfo lastTaskInfo = createResult.getLastTaskInfo();
    assertEquals("", lastTaskInfo.getTaskName());
    assertNull(createResult.currentTaskName());
    assertEquals(0L, createResult.getLastTaskTimeMillis());
    assertEquals(0L, lastTaskInfo.getTimeMillis());
    assertEquals(1, createResult.getTaskCount());
    TaskInfo[] taskInfo = createResult.getTaskInfo();
    assertEquals(1, taskInfo.length);
    assertFalse(createResult.isRunning());
    assertSame(lastTaskInfo, taskInfo[0]);
  }

  /**
   * Test {@link TbStopWatch#stopAndGetLastTaskTimeMillis()}.
   *
   * <ul>
   *   <li>Given create.
   *   <li>Then create LastTaskName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbStopWatch#stopAndGetLastTaskTimeMillis()}
   */
  @Test
  @DisplayName(
      "Test stopAndGetLastTaskTimeMillis(); given create; then create LastTaskName is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TbStopWatch.stopAndGetLastTaskTimeMillis()"})
  void testStopAndGetLastTaskTimeMillis_givenCreate_thenCreateLastTaskNameIsEmptyString()
      throws IllegalStateException {
    // Arrange
    TbStopWatch createResult = TbStopWatch.create();

    // Act
    long actualStopAndGetLastTaskTimeMillisResult = createResult.stopAndGetLastTaskTimeMillis();

    // Assert
    assertEquals("", createResult.getLastTaskName());
    TaskInfo lastTaskInfo = createResult.getLastTaskInfo();
    assertEquals("", lastTaskInfo.getTaskName());
    assertNull(createResult.currentTaskName());
    assertEquals(0L, createResult.getLastTaskTimeMillis());
    assertEquals(0L, lastTaskInfo.getTimeMillis());
    assertEquals(0L, actualStopAndGetLastTaskTimeMillisResult);
    assertEquals(1, createResult.getTaskCount());
    TaskInfo[] taskInfo = createResult.getTaskInfo();
    assertEquals(1, taskInfo.length);
    assertFalse(createResult.isRunning());
    assertSame(lastTaskInfo, taskInfo[0]);
  }

  /**
   * Test {@link TbStopWatch#stopAndGetLastTaskTimeNanos()}.
   *
   * <ul>
   *   <li>Given create.
   *   <li>Then create LastTaskName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbStopWatch#stopAndGetLastTaskTimeNanos()}
   */
  @Test
  @DisplayName(
      "Test stopAndGetLastTaskTimeNanos(); given create; then create LastTaskName is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TbStopWatch.stopAndGetLastTaskTimeNanos()"})
  void testStopAndGetLastTaskTimeNanos_givenCreate_thenCreateLastTaskNameIsEmptyString()
      throws IllegalStateException {
    // Arrange
    TbStopWatch createResult = TbStopWatch.create();

    // Act
    createResult.stopAndGetLastTaskTimeNanos();

    // Assert
    assertEquals("", createResult.getLastTaskName());
    TaskInfo lastTaskInfo = createResult.getLastTaskInfo();
    assertEquals("", lastTaskInfo.getTaskName());
    assertNull(createResult.currentTaskName());
    assertEquals(0L, createResult.getLastTaskTimeMillis());
    assertEquals(0L, lastTaskInfo.getTimeMillis());
    assertEquals(1, createResult.getTaskCount());
    TaskInfo[] taskInfo = createResult.getTaskInfo();
    assertEquals(1, taskInfo.length);
    assertFalse(createResult.isRunning());
    assertSame(lastTaskInfo, taskInfo[0]);
  }

  /**
   * Test new {@link TbStopWatch} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbStopWatch}
   */
  @Test
  @DisplayName("Test new TbStopWatch (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbStopWatch.<init>()"})
  void testNewTbStopWatch() {
    // Arrange and Act
    TbStopWatch actualTbStopWatch = new TbStopWatch();

    // Assert
    assertEquals("", actualTbStopWatch.getId());
    assertNull(actualTbStopWatch.currentTaskName());
    assertEquals(0, actualTbStopWatch.getTaskCount());
    assertEquals(0, actualTbStopWatch.getTaskInfo().length);
    assertEquals(0.0d, actualTbStopWatch.getTotalTimeSeconds());
    assertEquals(0L, actualTbStopWatch.getTotalTimeMillis());
    assertEquals(0L, actualTbStopWatch.getTotalTimeNanos());
    assertFalse(actualTbStopWatch.isRunning());
  }
}
