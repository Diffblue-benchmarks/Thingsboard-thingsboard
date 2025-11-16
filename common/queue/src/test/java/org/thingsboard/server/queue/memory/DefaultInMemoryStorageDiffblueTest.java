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
package org.thingsboard.server.queue.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.common.DefaultTbQueueMsg;
import org.thingsboard.server.queue.common.DefaultTbQueueMsgHeaders;

@ContextConfiguration(classes = {DefaultInMemoryStorage.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class DefaultInMemoryStorageDiffblueTest {
  @Autowired private DefaultInMemoryStorage defaultInMemoryStorage;

  /**
   * Test {@link DefaultInMemoryStorage#getLagTotal()}.
   *
   * <p>Method under test: {@link DefaultInMemoryStorage#getLagTotal()}
   */
  @Test
  @DisplayName("Test getLagTotal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultInMemoryStorage.getLagTotal()"})
  void testGetLagTotal() {
    // Arrange, Act and Assert
    assertEquals(0, defaultInMemoryStorage.getLagTotal());
  }

  /**
   * Test {@link DefaultInMemoryStorage#getLag(String)}.
   *
   * <p>Method under test: {@link DefaultInMemoryStorage#getLag(String)}
   */
  @Test
  @DisplayName("Test getLag(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultInMemoryStorage.getLag(String)"})
  void testGetLag() {
    // Arrange, Act and Assert
    assertEquals(0, defaultInMemoryStorage.getLag("Topic"));
  }

  /**
   * Test {@link DefaultInMemoryStorage#put(String, TbQueueMsg)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultInMemoryStorage#put(String, TbQueueMsg)}
   */
  @Test
  @DisplayName("Test put(String, TbQueueMsg); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultInMemoryStorage.put(String, TbQueueMsg)"})
  void testPut_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    DefaultTbQueueMsg msg = mock(DefaultTbQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(UUID.randomUUID());
    when(msg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());

    // Act
    boolean actualPutResult = defaultInMemoryStorage.put("Topic", new DefaultTbQueueMsg(msg));

    // Assert
    verify(msg).getData();
    verify(msg).getHeaders();
    verify(msg).getKey();
    assertEquals(1, defaultInMemoryStorage.getLagTotal());
    assertTrue(actualPutResult);
  }

  /**
   * Test {@link DefaultInMemoryStorage#put(String, TbQueueMsg)}.
   *
   * <ul>
   *   <li>Given {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultInMemoryStorage#put(String, TbQueueMsg)}
   */
  @Test
  @DisplayName("Test put(String, TbQueueMsg); given 'XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultInMemoryStorage.put(String, TbQueueMsg)"})
  void testPut_givenXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    DefaultTbQueueMsg msg = mock(DefaultTbQueueMsg.class);
    when(msg.getData()).thenReturn("\tXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(UUID.randomUUID());
    when(msg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());

    // Act
    boolean actualPutResult = defaultInMemoryStorage.put("Topic", new DefaultTbQueueMsg(msg));

    // Assert
    verify(msg).getData();
    verify(msg).getHeaders();
    verify(msg).getKey();
    assertEquals(1, defaultInMemoryStorage.getLagTotal());
    assertTrue(actualPutResult);
  }

  /**
   * Test {@link DefaultInMemoryStorage#get(String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultInMemoryStorage}.
   *   <li>When {@code Topic}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DefaultInMemoryStorage#get(String)}
   */
  @Test
  @DisplayName("Test get(String); given DefaultInMemoryStorage; when 'Topic'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DefaultInMemoryStorage.get(String)"})
  void testGet_givenDefaultInMemoryStorage_whenTopic_thenReturnEmpty() throws InterruptedException {
    // Arrange, Act and Assert
    assertTrue(defaultInMemoryStorage.get("Topic").isEmpty());
  }

  /**
   * Test {@link DefaultInMemoryStorage#get(String)}.
   *
   * <ul>
   *   <li>Then {@link DefaultInMemoryStorage} (default constructor) LagTotal is zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultInMemoryStorage#get(String)}
   */
  @Test
  @DisplayName(
      "Test get(String); then DefaultInMemoryStorage (default constructor) LagTotal is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DefaultInMemoryStorage.get(String)"})
  void testGet_thenDefaultInMemoryStorageLagTotalIsZero() throws InterruptedException {
    // Arrange
    DefaultInMemoryStorage defaultInMemoryStorage = new DefaultInMemoryStorage();
    defaultInMemoryStorage.put("Topic", mock(DefaultTbQueueMsg.class));

    // Act
    List<TbQueueMsg> actualGetResult = defaultInMemoryStorage.get("Topic");

    // Assert
    assertEquals(0, defaultInMemoryStorage.getLagTotal());
    assertEquals(1, actualGetResult.size());
  }
}
