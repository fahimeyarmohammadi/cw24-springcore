package ir.maktab.util;



import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Converter
public class StringListConverter implements AttributeConverter<List<String>,String> {
  private static final String SPLIT_CHAR =";";
    @Override
    public String convertToDatabaseColumn(List<String> stringList) {//  12345;23456
        return stringList!=null?String.join(SPLIT_CHAR,stringList):"";
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
      if(dbData!=null) {
          String[] stringArrray = dbData.split(SPLIT_CHAR);
          return Arrays.asList(stringArrray);

      }
      return new ArrayList<>();
    }
}
