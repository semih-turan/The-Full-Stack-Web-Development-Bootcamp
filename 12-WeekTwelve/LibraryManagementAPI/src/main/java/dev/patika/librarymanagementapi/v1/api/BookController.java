package dev.patika.librarymanagementapi.v1.api;

import dev.patika.librarymanagementapi.v1.business.abstracts.BookService;
import dev.patika.librarymanagementapi.v1.core.config.modelMapper.ModelMapperService;
import dev.patika.librarymanagementapi.v1.core.result.Result;
import dev.patika.librarymanagementapi.v1.core.result.ResultData;
import dev.patika.librarymanagementapi.v1.core.utils.ResultHelper;
import dev.patika.librarymanagementapi.v1.dto.request.book.BookSaveRequest;
import dev.patika.librarymanagementapi.v1.dto.request.book.BookUpdateRequest;
import dev.patika.librarymanagementapi.v1.dto.response.CursorResponse;
import dev.patika.librarymanagementapi.v1.dto.response.book.BookResponse;
import dev.patika.librarymanagementapi.v1.entites.Book;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final ModelMapperService mapperService;
    private final BookService bookServices;

    @GetMapping("{id}")
    public ResultData<BookResponse> getId(@PathVariable long id){
        BookResponse bookResponse = mapperService.forResponse().map(bookServices.getId(id),BookResponse.class);
        return ResultHelper.OK(bookResponse);
    }
    @PostMapping
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest){
        BookResponse bookResponse = mapperService.forResponse().map(bookServices.save(mapperService.forRequest().map(bookSaveRequest, Book.class)),BookResponse.class);
        return ResultHelper.CREATED(bookResponse);
    }
    @PutMapping
    public ResultData<BookResponse> update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest){
        BookResponse bookResponse = mapperService.forResponse().map(bookServices.update(mapperService.forRequest().map(bookUpdateRequest, Book.class)),BookResponse.class);
        return ResultHelper.OK(bookResponse);
    }
    @DeleteMapping("{id}")
    public Result delete(@PathVariable long id){
        return ResultHelper.OK(bookServices.delete(id));
    }
    @GetMapping
    public ResultData<CursorResponse<BookResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Page<Book> books = bookServices.cursor(page,pageSize);
        Page<BookResponse> bookResponses = books.map(category -> mapperService.forResponse().map(category,BookResponse.class));
        return ResultHelper.cursor(bookResponses);
    }
}
