package info.nemoworks.highlink.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import info.nemoworks.highlink.model.GantryCpcTransaction;
import info.nemoworks.highlink.model.GantryEtcTransaction;
import info.nemoworks.highlink.model.GantryRawTransaction;

@Mapper
public interface GantryMapper {

    GantryMapper INSTANCE = Mappers.getMapper(GantryMapper.class);

    GantryEtcTransaction gantryRawToEtcTransaction(GantryRawTransaction gantryRawTransaction);

    GantryCpcTransaction gantryRawToCpcTransaction(GantryRawTransaction gantryRawTransaction);

}
