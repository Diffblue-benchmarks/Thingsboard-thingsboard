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
package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.transform.MapEntry;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.queue.PartitionChangeMsg;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.tools.TbRateLimits;

@ExtendWith(MockitoExtension.class)
class TbDeviceStateNodeDiffblueTest {
  @Mock private ConcurrentReferenceHashMap<DeviceId, TbRateLimits> concurrentReferenceHashMap;

  @InjectMocks private TbDeviceStateNode tbDeviceStateNode;

  /**
   * Test {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given AlarmId(UUID) with id is randomUUID; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceStateNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenAlarmIdWithIdIsRandomUUID_thenCallsTellFailure() {
    // Arrange
    TbDeviceStateNode tbDeviceStateNode = new TbDeviceStateNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    tbDeviceStateNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentReferenceHashMap} {@link
   *       ConcurrentReferenceHashMap#compute(Object, BiFunction)} return {@code null}.
   *   <li>Then calls {@link ConcurrentReferenceHashMap#compute(Object, BiFunction)}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ConcurrentReferenceHashMap compute(Object, BiFunction) return 'null'; then calls compute(Object, BiFunction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceStateNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenConcurrentReferenceHashMapComputeReturnNull_thenCallsCompute() {
    // Arrange
    when(concurrentReferenceHashMap.compute(
            Mockito.<DeviceId>any(),
            Mockito.<BiFunction<DeviceId, TbRateLimits, TbRateLimits>>any()))
        .thenReturn(null);
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new DeviceId(UUID.randomUUID()));

    // Act
    tbDeviceStateNode.onMsg(ctx, msg);

    // Assert
    verify(concurrentReferenceHashMap).compute(isA(DeviceId.class), isA(BiFunction.class));
    verify(msg, atLeast(1)).getOriginator();
  }

  /**
   * Test {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext tellFailure(TbMsg, Throwable) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceStateNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextTellFailureThrowIllegalArgumentException() {
    // Arrange
    TbDeviceStateNode tbDeviceStateNode = new TbDeviceStateNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new IllegalArgumentException())
        .when(ctx)
        .tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceStateNode.onMsg(ctx, msg));
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getOriginator()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbMsg getOriginator() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceStateNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsgGetOriginatorThrowIllegalArgumentException() {
    // Arrange
    TbDeviceStateNode tbDeviceStateNode = new TbDeviceStateNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceStateNode.onMsg(ctx, msg));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbDeviceStateNode#onPartitionChangeMsg(TbContext, PartitionChangeMsg)}.
   *
   * <p>Method under test: {@link TbDeviceStateNode#onPartitionChangeMsg(TbContext,
   * PartitionChangeMsg)}
   */
  @Test
  @DisplayName("Test onPartitionChangeMsg(TbContext, PartitionChangeMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceStateNode.onPartitionChangeMsg(TbContext, PartitionChangeMsg)"})
  void testOnPartitionChangeMsg() {
    // Arrange
    when(concurrentReferenceHashMap.entrySet()).thenThrow(new IllegalArgumentException());
    TbContext ctx = mock(TbContext.class);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbDeviceStateNode.onPartitionChangeMsg(
                ctx, new PartitionChangeMsg(ServiceType.TB_CORE)));
    verify(concurrentReferenceHashMap).entrySet();
  }

  /**
   * Test {@link TbDeviceStateNode#onPartitionChangeMsg(TbContext, PartitionChangeMsg)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TbContext} {@link TbContext#isLocalEntity(EntityId)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNode#onPartitionChangeMsg(TbContext,
   * PartitionChangeMsg)}
   */
  @Test
  @DisplayName(
      "Test onPartitionChangeMsg(TbContext, PartitionChangeMsg); given 'false'; when TbContext isLocalEntity(EntityId) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceStateNode.onPartitionChangeMsg(TbContext, PartitionChangeMsg)"})
  void testOnPartitionChangeMsg_givenFalse_whenTbContextIsLocalEntityReturnFalse() {
    // Arrange
    HashSet<Entry<DeviceId, TbRateLimits>> entrySet = new HashSet<>();
    entrySet.add(new MapEntry<>());
    when(concurrentReferenceHashMap.entrySet()).thenReturn(entrySet);

    TbContext ctx = mock(TbContext.class);
    when(ctx.isLocalEntity(Mockito.<EntityId>any())).thenReturn(false);

    // Act
    tbDeviceStateNode.onPartitionChangeMsg(ctx, new PartitionChangeMsg(ServiceType.TB_CORE));

    // Assert
    verify(concurrentReferenceHashMap).entrySet();
    verify(ctx).isLocalEntity(isNull());
  }

  /**
   * Test {@link TbDeviceStateNode#onPartitionChangeMsg(TbContext, PartitionChangeMsg)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNode#onPartitionChangeMsg(TbContext,
   * PartitionChangeMsg)}
   */
  @Test
  @DisplayName(
      "Test onPartitionChangeMsg(TbContext, PartitionChangeMsg); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceStateNode.onPartitionChangeMsg(TbContext, PartitionChangeMsg)"})
  void testOnPartitionChangeMsg_givenIllegalArgumentException() {
    // Arrange
    HashSet<Entry<DeviceId, TbRateLimits>> entrySet = new HashSet<>();
    entrySet.add(new MapEntry<>());
    when(concurrentReferenceHashMap.entrySet()).thenReturn(entrySet);

    TbContext ctx = mock(TbContext.class);
    when(ctx.isLocalEntity(Mockito.<EntityId>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbDeviceStateNode.onPartitionChangeMsg(
                ctx, new PartitionChangeMsg(ServiceType.TB_CORE)));
    verify(concurrentReferenceHashMap).entrySet();
    verify(ctx).isLocalEntity(isNull());
  }

  /**
   * Test {@link TbDeviceStateNode#onPartitionChangeMsg(TbContext, PartitionChangeMsg)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link TbContext} {@link TbContext#isLocalEntity(EntityId)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNode#onPartitionChangeMsg(TbContext,
   * PartitionChangeMsg)}
   */
  @Test
  @DisplayName(
      "Test onPartitionChangeMsg(TbContext, PartitionChangeMsg); given 'true'; when TbContext isLocalEntity(EntityId) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceStateNode.onPartitionChangeMsg(TbContext, PartitionChangeMsg)"})
  void testOnPartitionChangeMsg_givenTrue_whenTbContextIsLocalEntityReturnTrue() {
    // Arrange
    HashSet<Entry<DeviceId, TbRateLimits>> entrySet = new HashSet<>();
    entrySet.add(new MapEntry<>());
    when(concurrentReferenceHashMap.entrySet()).thenReturn(entrySet);

    TbContext ctx = mock(TbContext.class);
    when(ctx.isLocalEntity(Mockito.<EntityId>any())).thenReturn(true);

    // Act
    tbDeviceStateNode.onPartitionChangeMsg(ctx, new PartitionChangeMsg(ServiceType.TB_CORE));

    // Assert
    verify(concurrentReferenceHashMap).entrySet();
    verify(ctx).isLocalEntity(isNull());
  }

  /**
   * Test {@link TbDeviceStateNode#onPartitionChangeMsg(TbContext, PartitionChangeMsg)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link TbContext} {@link TbContext#isLocalEntity(EntityId)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNode#onPartitionChangeMsg(TbContext,
   * PartitionChangeMsg)}
   */
  @Test
  @DisplayName(
      "Test onPartitionChangeMsg(TbContext, PartitionChangeMsg); given 'true'; when TbContext isLocalEntity(EntityId) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceStateNode.onPartitionChangeMsg(TbContext, PartitionChangeMsg)"})
  void testOnPartitionChangeMsg_givenTrue_whenTbContextIsLocalEntityReturnTrue2() {
    // Arrange
    HashSet<Entry<DeviceId, TbRateLimits>> entrySet = new HashSet<>();
    entrySet.add(new MapEntry<>());
    entrySet.add(new MapEntry<>());
    when(concurrentReferenceHashMap.entrySet()).thenReturn(entrySet);

    TbContext ctx = mock(TbContext.class);
    when(ctx.isLocalEntity(Mockito.<EntityId>any())).thenReturn(true);

    // Act
    tbDeviceStateNode.onPartitionChangeMsg(ctx, new PartitionChangeMsg(ServiceType.TB_CORE));

    // Assert
    verify(concurrentReferenceHashMap).entrySet();
    verify(ctx, atLeast(1)).isLocalEntity(isNull());
  }

  /**
   * Test {@link TbDeviceStateNode#onPartitionChangeMsg(TbContext, PartitionChangeMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNode#onPartitionChangeMsg(TbContext,
   * PartitionChangeMsg)}
   */
  @Test
  @DisplayName("Test onPartitionChangeMsg(TbContext, PartitionChangeMsg); when TbContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceStateNode.onPartitionChangeMsg(TbContext, PartitionChangeMsg)"})
  void testOnPartitionChangeMsg_whenTbContext() {
    // Arrange
    when(concurrentReferenceHashMap.entrySet()).thenReturn(new HashSet<>());
    TbContext ctx = mock(TbContext.class);

    // Act
    tbDeviceStateNode.onPartitionChangeMsg(ctx, new PartitionChangeMsg(ServiceType.TB_CORE));

    // Assert
    verify(concurrentReferenceHashMap).entrySet();
  }
}
