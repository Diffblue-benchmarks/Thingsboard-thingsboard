package org.thingsboard.server.controller;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class EntitiesVersionControlControllerDiffblueTest {
  @InjectMocks
  private EntitiesVersionControlController entitiesVersionControlController;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link EntitiesVersionControlController#compareEntityDataToVersion(EntityType, UUID, String)}.
   * <p>
   * Method under test: {@link EntitiesVersionControlController#compareEntityDataToVersion(EntityType, UUID, String)}
   */
  @Test
  @DisplayName("Test compareEntityDataToVersion(EntityType, UUID, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.springframework.web.context.request.async.DeferredResult EntitiesVersionControlController.compareEntityDataToVersion(EntityType, UUID, String)"})
  void testCompareEntityDataToVersion() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/api/entities/vc/diff/{entityType}/{internalEntityUuid}", "Uri Variables", "Uri Variables",
            "Uri Variables")
        .param("versionId", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
