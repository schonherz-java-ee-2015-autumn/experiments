package hu.schonherz.training.java.solid.converter;

public interface Converter<S, T> {
  T convert(S source) throws ConversionException;
}
