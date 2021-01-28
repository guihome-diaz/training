import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from "@angular/router";
import {SharedData} from "./shared-data";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ActionableWhenLoggedIn implements CanActivate {

  constructor(private sharedData: SharedData, private router: Router) {
  }


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    // Javascript trick: put 2 !! mark to trick the typescript
    let isAllowed =!! this.sharedData.sessionId;

    if (!isAllowed) {
      // redirect user to login page
      this.router.navigate(["/login"]);
    }
    // return boolean true
    return isAllowed;
  }

}
