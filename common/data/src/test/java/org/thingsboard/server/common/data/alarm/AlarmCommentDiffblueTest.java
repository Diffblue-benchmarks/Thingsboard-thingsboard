package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlarmCommentDiffblueTest {
  /**
   * Test {@link AlarmComment#getId()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmComment#getId()}
   */
  @Test
  @DisplayName("Test getId(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.AlarmCommentId AlarmComment.getId()"})
  void testGetId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new AlarmComment().getId());
  }

  /**
   * Test {@link AlarmComment#getCreatedTime()}.
   *
   * <p>Method under test: {@link AlarmComment#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long AlarmComment.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new AlarmComment().getCreatedTime());
  }

  /**
   * Test {@link AlarmComment#AlarmComment(AlarmComment)}.
   *
   * <p>Method under test: {@link AlarmComment#AlarmComment(AlarmComment)}
   */
  @Test
  @DisplayName("Test new AlarmComment(AlarmComment)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmComment.<init>(AlarmComment)"})
  void testNewAlarmComment() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();

    // Act and Assert
    assertEquals(alarmComment, new AlarmComment(alarmComment));
  }

  /**
   * Test {@link AlarmComment#getName()}.
   *
   * <ul>
   *   <li>Given {@link AlarmComment#AlarmComment()} Comment is Instance.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmComment#getName()}
   */
  @Test
  @DisplayName("Test getName(); given AlarmComment() Comment is Instance; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmComment.getName()"})
  void testGetName_givenAlarmCommentCommentIsInstance_thenReturnEmptyString() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(MissingNode.getInstance());

    // Act and Assert
    assertEquals("", alarmComment.getName());
  }

  /**
   * Test {@link AlarmComment#getName()}.
   *
   * <ul>
   *   <li>Given {@link AlarmComment#AlarmComment()} Comment is valueOf ten.
   *   <li>Then return {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmComment#getName()}
   */
  @Test
  @DisplayName("Test getName(); given AlarmComment() Comment is valueOf ten; then return '10.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmComment.getName()"})
  void testGetName_givenAlarmCommentCommentIsValueOfTen_thenReturn100() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertEquals("10.0", alarmComment.getName());
  }

  /**
   * Test {@link AlarmComment#getName()}.
   *
   * <ul>
   *   <li>Then return {@code ["Pojo"]}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmComment#getName()}
   */
  @Test
  @DisplayName("Test getName(); then return '[\"Pojo\"]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmComment.getName()"})
  void testGetName_thenReturnPojo() {
    // Arrange
    ArrayNode comment = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    comment.addPOJO("Pojo");

    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setComment(comment);

    // Act and Assert
    assertEquals("[\"Pojo\"]", alarmComment.getName());
  }
}
