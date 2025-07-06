package org.thingsboard.server.queue.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.Advice;
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
import org.thingsboard.server.queue.common.TbProtoJsQueueMsg;

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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DefaultInMemoryStorage.getLag(String)"})
  void testGetLag() {
    // Arrange, Act and Assert
    assertEquals(0, defaultInMemoryStorage.getLag("Topic"));
  }

  /**
   * Test {@link DefaultInMemoryStorage#put(String, TbQueueMsg)}.
   *
   * <p>Method under test: {@link DefaultInMemoryStorage#put(String, TbQueueMsg)}
   */
  @Test
  @DisplayName("Test put(String, TbQueueMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultInMemoryStorage.put(String, TbQueueMsg)"})
  void testPut() {
    // Arrange
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Advice defaultInstance = Advice.getDefaultInstance();

    // Act
    boolean actualPutResult =
        defaultInMemoryStorage.put(
            "Topic",
            new DefaultTbQueueMsg(
                new TbProtoJsQueueMsg<>(key, defaultInstance, new DefaultTbQueueMsgHeaders())));

    // Assert
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List DefaultInMemoryStorage.get(String)"})
  void testGet_thenDefaultInMemoryStorageLagTotalIsZero() throws InterruptedException {
    // Arrange
    DefaultInMemoryStorage defaultInMemoryStorage = new DefaultInMemoryStorage();
    UUID key = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DefaultTbQueueMsg msg =
        new DefaultTbQueueMsg(new TbProtoJsQueueMsg<>(key, Advice.getDefaultInstance()));
    defaultInMemoryStorage.put("Topic", msg);

    // Act
    List<TbQueueMsg> actualGetResult = defaultInMemoryStorage.get("Topic");

    // Assert
    assertEquals(0, defaultInMemoryStorage.getLagTotal());
    assertEquals(1, actualGetResult.size());
    assertSame(msg, actualGetResult.get(0));
  }
}
