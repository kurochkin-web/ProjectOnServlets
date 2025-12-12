package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    private UUID id;
    private String title;
    private Integer categoryId;
    private String description;
    private List<Question> questionList;
}

//многие ко многим - связь делается отдельной таблицей где есть 2 колонки userid и testid
//добавить связи через список
