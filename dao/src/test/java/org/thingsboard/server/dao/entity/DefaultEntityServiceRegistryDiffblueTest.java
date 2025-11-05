package org.thingsboard.server.dao.entity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;

@ContextConfiguration(classes = {DefaultEntityServiceRegistry.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class DefaultEntityServiceRegistryDiffblueTest {
  @Autowired private DefaultEntityServiceRegistry defaultEntityServiceRegistry;

  @MockBean private EntityDaoService entityDaoService;

  @Autowired private List<EntityDaoService> list;



  /**
   * Test {@link DefaultEntityServiceRegistry#getServiceByEntityType(EntityType)}.
   *
   * <p>Method under test: {@link DefaultEntityServiceRegistry#getServiceByEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test getServiceByEntityType(EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityDaoService DefaultEntityServiceRegistry.getServiceByEntityType(EntityType)"
  })
  void testGetServiceByEntityType() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultEntityServiceRegistry.getServiceByEntityType(EntityType.TENANT));
  }
}
