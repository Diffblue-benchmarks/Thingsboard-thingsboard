package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;

class TbDummyLwM2MClientStoreDiffblueTest {
  /**
   * Test {@link TbDummyLwM2MClientStore#get(String)}.
   * <p>
   * Method under test: {@link TbDummyLwM2MClientStore#get(String)}
   */
  @Test
  @DisplayName("Test get(String)")
  void testGet() {
    // Arrange, Act and Assert
    assertNull((new TbDummyLwM2MClientStore()).get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbDummyLwM2MClientStore#getAll()}.
   * <p>
   * Method under test: {@link TbDummyLwM2MClientStore#getAll()}
   */
  @Test
  @DisplayName("Test getAll()")
  void testGetAll() {
    // Arrange, Act and Assert
    assertTrue((new TbDummyLwM2MClientStore()).getAll().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbDummyLwM2MClientStore}
   *   <li>{@link TbDummyLwM2MClientStore#put(LwM2mClient)}
   *   <li>{@link TbDummyLwM2MClientStore#remove(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbDummyLwM2MClientStore actualTbDummyLwM2MClientStore = new TbDummyLwM2MClientStore();
    actualTbDummyLwM2MClientStore.put(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    actualTbDummyLwM2MClientStore.remove("https://config.us-east-2.amazonaws.com");

    // Assert that nothing has changed
    assertTrue(actualTbDummyLwM2MClientStore.getAll().isEmpty());
  }
}
