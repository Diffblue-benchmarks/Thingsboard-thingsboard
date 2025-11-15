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
package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.concurrent.ScheduledFuture;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.transport.SessionMsgListener;
import org.thingsboard.server.gen.transport.TransportProtos;

class SessionMetaDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SessionMetaData#equals(Object)}
   *   <li>{@link SessionMetaData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SessionMetaData sessionMetaData = new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, null);
    SessionMetaData sessionMetaData2 = new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, null);

    // Act and Assert
    assertEquals(sessionMetaData, sessionMetaData2);
    int expectedHashCodeResult = sessionMetaData.hashCode();
    assertEquals(expectedHashCodeResult, sessionMetaData2.hashCode());
  }

  /**
   * Method under test: {@link SessionMetaData#hasScheduledFuture()}
   */
  @Test
  void testHasScheduledFuture() {
    // Arrange, Act and Assert
    assertFalse((new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class))).hasScheduledFuture());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SessionMetaData#equals(Object)}
   *   <li>{@link SessionMetaData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SessionMetaData sessionMetaData = new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class));

    // Act and Assert
    assertEquals(sessionMetaData, sessionMetaData);
    int expectedHashCodeResult = sessionMetaData.hashCode();
    assertEquals(expectedHashCodeResult, sessionMetaData.hashCode());
  }

  /**
   * Method under test: {@link SessionMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SessionMetaData sessionMetaData = new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class));

    // Act and Assert
    assertNotEquals(sessionMetaData, new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class)));
  }

  /**
   * Method under test: {@link SessionMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SessionMetaData sessionMetaData = new SessionMetaData(null, TransportProtos.SessionType.SYNC,
        mock(SessionMsgListener.class));

    // Act and Assert
    assertNotEquals(sessionMetaData, new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class)));
  }

  /**
   * Method under test: {@link SessionMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SessionMetaData sessionMetaData = new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(), null,
        mock(SessionMsgListener.class));

    // Act and Assert
    assertNotEquals(sessionMetaData, new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class)));
  }

  /**
   * Method under test: {@link SessionMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SessionMetaData sessionMetaData = new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.ASYNC, mock(SessionMsgListener.class));

    // Act and Assert
    assertNotEquals(sessionMetaData, new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class)));
  }

  /**
   * Method under test: {@link SessionMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SessionMetaData sessionMetaData = new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, null);

    // Act and Assert
    assertNotEquals(sessionMetaData, new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class)));
  }

  /**
   * Method under test: {@link SessionMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SessionMetaData sessionMetaData = new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class));

    // Act and Assert
    assertNotEquals(sessionMetaData,
        new SessionMetaData(null, TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class)));
  }

  /**
   * Method under test: {@link SessionMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SessionMetaData sessionMetaData = new SessionMetaData(null, TransportProtos.SessionType.SYNC,
        mock(SessionMsgListener.class));

    // Act and Assert
    assertNotEquals(sessionMetaData,
        new SessionMetaData(null, TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class)));
  }

  /**
   * Method under test: {@link SessionMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    SessionMetaData sessionMetaData = new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(), null,
        mock(SessionMsgListener.class));

    // Act and Assert
    assertNotEquals(sessionMetaData, new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(), null,
        mock(SessionMsgListener.class)));
  }

  /**
   * Method under test: {@link SessionMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    SessionMetaData sessionMetaData = new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class));
    sessionMetaData.setSubscribedToAttributes(true);

    // Act and Assert
    assertNotEquals(sessionMetaData, new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class)));
  }

  /**
   * Method under test: {@link SessionMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    SessionMetaData sessionMetaData = new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class));
    sessionMetaData.setSubscribedToRPC(true);

    // Act and Assert
    assertNotEquals(sessionMetaData, new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class)));
  }

  /**
   * Method under test: {@link SessionMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    SessionMetaData sessionMetaData = new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class));
    sessionMetaData.setOverwriteActivityTime(true);

    // Act and Assert
    assertNotEquals(sessionMetaData, new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class)));
  }

  /**
   * Method under test: {@link SessionMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class)), null);
  }

  /**
   * Method under test: {@link SessionMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, mock(SessionMsgListener.class)), "Different type to SessionMetaData");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SessionMetaData#SessionMetaData(TransportProtos.SessionInfoProto, TransportProtos.SessionType, SessionMsgListener)}
   *   <li>{@link SessionMetaData#setOverwriteActivityTime(boolean)}
   *   <li>{@link SessionMetaData#setScheduledFuture(ScheduledFuture)}
   *   <li>{@link SessionMetaData#setSessionInfo(TransportProtos.SessionInfoProto)}
   *   <li>{@link SessionMetaData#setSubscribedToAttributes(boolean)}
   *   <li>{@link SessionMetaData#setSubscribedToRPC(boolean)}
   *   <li>{@link SessionMetaData#toString()}
   *   <li>{@link SessionMetaData#getListener()}
   *   <li>{@link SessionMetaData#getScheduledFuture()}
   *   <li>{@link SessionMetaData#getSessionInfo()}
   *   <li>{@link SessionMetaData#getSessionType()}
   *   <li>{@link SessionMetaData#isOverwriteActivityTime()}
   *   <li>{@link SessionMetaData#isSubscribedToAttributes()}
   *   <li>{@link SessionMetaData#isSubscribedToRPC()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    SessionMsgListener listener = mock(SessionMsgListener.class);

    // Act
    SessionMetaData actualSessionMetaData = new SessionMetaData(TransportProtos.SessionInfoProto.getDefaultInstance(),
        TransportProtos.SessionType.SYNC, listener);
    actualSessionMetaData.setOverwriteActivityTime(true);
    actualSessionMetaData.setScheduledFuture(null);
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();
    actualSessionMetaData.setSessionInfo(sessionInfo);
    actualSessionMetaData.setSubscribedToAttributes(true);
    actualSessionMetaData.setSubscribedToRPC(true);
    actualSessionMetaData.toString();
    SessionMsgListener actualListener = actualSessionMetaData.getListener();
    actualSessionMetaData.getScheduledFuture();
    TransportProtos.SessionInfoProto actualSessionInfo = actualSessionMetaData.getSessionInfo();
    TransportProtos.SessionType actualSessionType = actualSessionMetaData.getSessionType();
    boolean actualIsOverwriteActivityTimeResult = actualSessionMetaData.isOverwriteActivityTime();
    boolean actualIsSubscribedToAttributesResult = actualSessionMetaData.isSubscribedToAttributes();

    // Assert that nothing has changed
    assertEquals(TransportProtos.SessionType.SYNC, actualSessionType);
    assertTrue(actualIsOverwriteActivityTimeResult);
    assertTrue(actualIsSubscribedToAttributesResult);
    assertTrue(actualSessionMetaData.isSubscribedToRPC());
    assertSame(sessionInfo, actualSessionInfo);
    assertSame(listener, actualListener);
  }
}
