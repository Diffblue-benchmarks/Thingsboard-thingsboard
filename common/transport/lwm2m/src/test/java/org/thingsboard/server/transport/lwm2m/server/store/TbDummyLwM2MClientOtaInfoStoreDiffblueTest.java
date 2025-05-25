package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbDummyLwM2MClientOtaInfoStoreDiffblueTest {
  /**
   * Test {@link TbDummyLwM2MClientOtaInfoStore#getFw(String)}.
   * <p>
   * Method under test: {@link TbDummyLwM2MClientOtaInfoStore#getFw(String)}
   */
  @Test
  @DisplayName("Test getFw(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MClientFwOtaInfo TbDummyLwM2MClientOtaInfoStore.getFw(String)"})
  void testGetFw() {
    // Arrange, Act and Assert
    assertNull((new TbDummyLwM2MClientOtaInfoStore()).getFw("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbDummyLwM2MClientOtaInfoStore#getSw(String)}.
   * <p>
   * Method under test: {@link TbDummyLwM2MClientOtaInfoStore#getSw(String)}
   */
  @Test
  @DisplayName("Test getSw(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.transport.lwm2m.server.ota.software.LwM2MClientSwOtaInfo TbDummyLwM2MClientOtaInfoStore.getSw(String)"})
  void testGetSw() {
    // Arrange, Act and Assert
    assertNull((new TbDummyLwM2MClientOtaInfoStore()).getSw("https://config.us-east-2.amazonaws.com"));
  }
}
