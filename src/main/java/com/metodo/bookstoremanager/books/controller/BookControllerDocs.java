package com.metodo.bookstoremanager.books.controller;

import com.metodo.bookstoremanager.books.dto.BookRequestDTO;
import com.metodo.bookstoremanager.books.dto.BookResponseDTO;
import com.metodo.bookstoremanager.users.dto.AuthenticatedUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@Api("Books module management")
public interface BookControllerDocs {

    @ApiOperation(value = "Book creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success book creation"),
            @ApiResponse(code = 400, message = "Missing required field, wrong field range value or book already registered on system")
    })
    BookResponseDTO create(AuthenticatedUser authenticatedUser, BookRequestDTO bookRequestDTO);

    @ApiOperation(value = "Find a book by id operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success book found"),
            @ApiResponse(code = 404, message = "Book not found error")
    })
    BookResponseDTO findByIdAndUser(AuthenticatedUser authenticatedUser, Long bookId);

    @ApiOperation(value = "List all books specific authenticated user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book list found by authenticated user informed"),
    })
    List<BookResponseDTO> findAllByUser(AuthenticatedUser authenticatedUser);

    @ApiOperation(value = "Book delete operation")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Book by user successfully deleted"),
            @ApiResponse(code = 404, message = "Book not found error")
    })
    void deleteByIdAndUser(AuthenticatedUser authenticatedUser, Long bookId);

    @ApiOperation(value = "Update a book by id operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book by user successfully updated"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or book already registered on system"),
            @ApiResponse(code = 404, message = "Book not found error")
    })
    BookResponseDTO updateByIdAndUser(AuthenticatedUser authenticatedUser, Long bookId, BookRequestDTO bookRequestDTO);
}
