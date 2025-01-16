package org.thingsboard.server.queue.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.Advice;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.common.DefaultTbQueueMsg;
import org.thingsboard.server.queue.common.DefaultTbQueueMsgHeaders;
import org.thingsboard.server.queue.common.TbProtoJsQueueMsg;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {DefaultInMemoryStorage.class})
@ExtendWith(SpringExtension.class)
class DefaultInMemoryStorageDiffblueTest {
  @Autowired
  private DefaultInMemoryStorage defaultInMemoryStorage;

  /**
   * Test {@link DefaultInMemoryStorage#printStats()}.
   * <p>
   * Method under test: {@link DefaultInMemoryStorage#printStats()}
   */
  @Test
  @DisplayName("Test printStats()")
  void testPrintStats() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    defaultInMemoryStorage.printStats();
  }

  /**
   * Test {@link DefaultInMemoryStorage#printStats()}.
   * <ul>
   *   <li>Then calls {@link DefaultTbQueueMsg#getData()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultInMemoryStorage#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); then calls getData()")
  void testPrintStats_thenCallsGetData() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbQueueMsg msg = mock(DefaultTbQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(msg.getHeaders()).thenReturn(new DefaultTbQueueMsgHeaders());
    DefaultTbQueueMsg msg2 = new DefaultTbQueueMsg(msg);

    DefaultInMemoryStorage defaultInMemoryStorage = new DefaultInMemoryStorage();
    defaultInMemoryStorage.put("Topic", msg2);

    // Act
    defaultInMemoryStorage.printStats();

    // Assert that nothing has changed
    verify(msg).getData();
    verify(msg).getHeaders();
    verify(msg).getKey();
  }

  /**
   * Test {@link DefaultInMemoryStorage#getLagTotal()}.
   * <p>
   * Method under test: {@link DefaultInMemoryStorage#getLagTotal()}
   */
  @Test
  @DisplayName("Test getLagTotal()")
  void testGetLagTotal() {
    // Arrange, Act and Assert
    assertEquals(0, defaultInMemoryStorage.getLagTotal());
  }

  /**
   * Test {@link DefaultInMemoryStorage#getLag(String)}.
   * <p>
   * Method under test: {@link DefaultInMemoryStorage#getLag(String)}
   */
  @Test
  @DisplayName("Test getLag(String)")
  void testGetLag() {
    // Arrange, Act and Assert
    assertEquals(0, defaultInMemoryStorage.getLag("Topic"));
  }

  /**
   * Test {@link DefaultInMemoryStorage#put(String, TbQueueMsg)}.
   * <p>
   * Method under test: {@link DefaultInMemoryStorage#put(String, TbQueueMsg)}
   */
  @Test
  @DisplayName("Test put(String, TbQueueMsg)")
  void testPut() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    boolean actualPutResult = defaultInMemoryStorage.put("Topic",
        new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance())));

    // Assert
    assertEquals(1, defaultInMemoryStorage.getLagTotal());
    assertTrue(actualPutResult);
  }

  /**
   * Test {@link DefaultInMemoryStorage#put(String, TbQueueMsg)}.
   * <p>
   * Method under test: {@link DefaultInMemoryStorage#put(String, TbQueueMsg)}
   */
  @Test
  @DisplayName("Test put(String, TbQueueMsg)")
  void testPut2() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act
    boolean actualPutResult = defaultInMemoryStorage.put("Topic",
        new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, defaultInstance, new DefaultTbQueueMsgHeaders())));

    // Assert
    assertEquals(1, defaultInMemoryStorage.getLagTotal());
    assertTrue(actualPutResult);
  }

  /**
   * Test {@link DefaultInMemoryStorage#put(String, TbQueueMsg)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then calls {@link DefaultTbQueueMsg#getData()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultInMemoryStorage#put(String, TbQueueMsg)}
   */
  @Test
  @DisplayName("Test put(String, TbQueueMsg); given 'AXAXAXAX' Bytes is 'UTF-8'; then calls getData()")
  void testPut_givenAxaxaxaxBytesIsUtf8_thenCallsGetData() throws UnsupportedEncodingException {
    // Arrange
    DefaultTbQueueMsg msg = mock(DefaultTbQueueMsg.class);
    when(msg.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(msg.getKey()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
   * <ul>
   *   <li>When {@code Topic}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultInMemoryStorage#get(String)}
   */
  @Test
  @DisplayName("Test get(String); when 'Topic'; then return Empty")
  void testGet_whenTopic_thenReturnEmpty() throws InterruptedException {
    // Arrange, Act and Assert
    assertTrue(defaultInMemoryStorage.get("Topic").isEmpty());
  }
}
