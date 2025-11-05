package org.thingsboard.server.dao.entity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.Dao;

@ContextConfiguration(classes = {EntityDaoRegistry.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class EntityDaoRegistryDiffblueTest {
  @MockBean private Dao<Object> dao;

  @Autowired private EntityDaoRegistry entityDaoRegistry;

  @Autowired private List<Dao<Object>> list;

  /**
   * Test {@link EntityDaoRegistry#getDao(EntityType)}.
   *
   * <p>Method under test: {@link EntityDaoRegistry#getDao(EntityType)}
   */
  @Test
  @DisplayName("Test getDao(EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Dao EntityDaoRegistry.getDao(EntityType)"})
  void testGetDao() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityDaoRegistry.getDao(EntityType.TENANT));
  }
}
