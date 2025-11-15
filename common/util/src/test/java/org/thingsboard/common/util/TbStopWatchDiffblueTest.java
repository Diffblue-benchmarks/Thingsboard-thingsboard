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
package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

class TbStopWatchDiffblueTest {
  /**
   * Method under test: {@link TbStopWatch#create()}
   */
  @Test
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
   * Method under test: {@link TbStopWatch#create(String)}
   */
  @Test
  void testCreate2() {
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
   * Method under test: {@link TbStopWatch#startNew(String)}
   */
  @Test
  void testStartNew() throws IllegalStateException {
    // Arrange
    TbStopWatch createResult = TbStopWatch.create();

    // Act
    createResult.startNew("Task Name");

    // Assert
    assertEquals("", createResult.getLastTaskName());
    StopWatch.TaskInfo lastTaskInfo = createResult.getLastTaskInfo();
    assertEquals("", lastTaskInfo.getTaskName());
    assertEquals("Task Name", createResult.currentTaskName());
    assertEquals(0L, createResult.getLastTaskTimeMillis());
    assertEquals(0L, lastTaskInfo.getTimeMillis());
    assertEquals(1, createResult.getTaskCount());
    StopWatch.TaskInfo[] taskInfo = createResult.getTaskInfo();
    assertEquals(1, taskInfo.length);
    assertSame(lastTaskInfo, taskInfo[0]);
  }

  /**
   * Method under test: {@link TbStopWatch#stopAndGetTotalTimeMillis()}
   */
  @Test
  void testStopAndGetTotalTimeMillis() throws IllegalStateException {
    // Arrange
    TbStopWatch createResult = TbStopWatch.create();

    // Act
    long actualStopAndGetTotalTimeMillisResult = createResult.stopAndGetTotalTimeMillis();

    // Assert
    assertEquals("", createResult.getLastTaskName());
    StopWatch.TaskInfo lastTaskInfo = createResult.getLastTaskInfo();
    assertEquals("", lastTaskInfo.getTaskName());
    assertNull(createResult.currentTaskName());
    assertEquals(0L, createResult.getLastTaskTimeMillis());
    assertEquals(0L, lastTaskInfo.getTimeMillis());
    assertEquals(0L, actualStopAndGetTotalTimeMillisResult);
    assertEquals(1, createResult.getTaskCount());
    StopWatch.TaskInfo[] taskInfo = createResult.getTaskInfo();
    assertEquals(1, taskInfo.length);
    assertFalse(createResult.isRunning());
    assertSame(lastTaskInfo, taskInfo[0]);
  }

  /**
   * Method under test: {@link TbStopWatch#stopAndGetTotalTimeNanos()}
   */
  @Test
  void testStopAndGetTotalTimeNanos() throws IllegalStateException {
    // Arrange
    TbStopWatch createResult = TbStopWatch.create();

    // Act
    createResult.stopAndGetTotalTimeNanos();

    // Assert
    assertEquals("", createResult.getLastTaskName());
    StopWatch.TaskInfo lastTaskInfo = createResult.getLastTaskInfo();
    assertEquals("", lastTaskInfo.getTaskName());
    assertNull(createResult.currentTaskName());
    assertEquals(0L, createResult.getLastTaskTimeMillis());
    assertEquals(0L, lastTaskInfo.getTimeMillis());
    assertEquals(1, createResult.getTaskCount());
    StopWatch.TaskInfo[] taskInfo = createResult.getTaskInfo();
    assertEquals(1, taskInfo.length);
    assertFalse(createResult.isRunning());
    assertSame(lastTaskInfo, taskInfo[0]);
  }

  /**
   * Method under test: {@link TbStopWatch#stopAndGetLastTaskTimeMillis()}
   */
  @Test
  void testStopAndGetLastTaskTimeMillis() throws IllegalStateException {
    // Arrange
    TbStopWatch createResult = TbStopWatch.create();

    // Act
    long actualStopAndGetLastTaskTimeMillisResult = createResult.stopAndGetLastTaskTimeMillis();

    // Assert
    assertEquals("", createResult.getLastTaskName());
    StopWatch.TaskInfo lastTaskInfo = createResult.getLastTaskInfo();
    assertEquals("", lastTaskInfo.getTaskName());
    assertNull(createResult.currentTaskName());
    assertEquals(0L, createResult.getLastTaskTimeMillis());
    assertEquals(0L, lastTaskInfo.getTimeMillis());
    assertEquals(0L, actualStopAndGetLastTaskTimeMillisResult);
    assertEquals(1, createResult.getTaskCount());
    StopWatch.TaskInfo[] taskInfo = createResult.getTaskInfo();
    assertEquals(1, taskInfo.length);
    assertFalse(createResult.isRunning());
    assertSame(lastTaskInfo, taskInfo[0]);
  }

  /**
   * Method under test: {@link TbStopWatch#stopAndGetLastTaskTimeNanos()}
   */
  @Test
  void testStopAndGetLastTaskTimeNanos() throws IllegalStateException {
    // Arrange
    TbStopWatch createResult = TbStopWatch.create();

    // Act
    createResult.stopAndGetLastTaskTimeNanos();

    // Assert
    assertEquals("", createResult.getLastTaskName());
    StopWatch.TaskInfo lastTaskInfo = createResult.getLastTaskInfo();
    assertEquals("", lastTaskInfo.getTaskName());
    assertNull(createResult.currentTaskName());
    assertEquals(0L, createResult.getLastTaskTimeMillis());
    assertEquals(0L, lastTaskInfo.getTimeMillis());
    assertEquals(1, createResult.getTaskCount());
    StopWatch.TaskInfo[] taskInfo = createResult.getTaskInfo();
    assertEquals(1, taskInfo.length);
    assertFalse(createResult.isRunning());
    assertSame(lastTaskInfo, taskInfo[0]);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TbStopWatch}
   */
  @Test
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
