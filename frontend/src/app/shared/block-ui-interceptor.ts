import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, finalize} from 'rxjs/operators';
import {BlockUI, NgBlockUI} from 'ng-block-ui';

@Injectable({
    providedIn: 'root'
})

export class BlockUIInterceptor implements HttpInterceptor {

    @BlockUI() blockUI: NgBlockUI;

    intercept(
        req: HttpRequest<any>,
        next: HttpHandler
    ): Observable<HttpEvent<any>> {
        this.blockUI.start('Carregando...');
        return next.handle(req).pipe(
            catchError(error => {
                this.blockUI.stop();
                return throwError(error);
            }),
            finalize(() => {
                this.blockUI.stop();
            })
        );
    }
}