package ru.flish1.atmsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.flish1.atmsystem.dto.AccountRegisterDto;
import ru.flish1.atmsystem.entity.Account;

@Mapper(componentModel = "spring")
public interface AccountRegisterDtoMapper {
    @Mappings(value = {
            @Mapping(source = "holder.profile", target = "holderProfile"),
            @Mapping(source = "bank.title", target = "bankTitle")
    }
    )
    AccountRegisterDto accountToAccountDto(Account account);

    @Mappings(value = {
            @Mapping(source = "holderProfile", target = "holder.profile"),
            @Mapping(source = "bankTitle", target = "bank.title")
    }
    )
    Account accountDtoToAccount(AccountRegisterDto accountDto);
}
